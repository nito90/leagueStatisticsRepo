package com.toulios.leaguestatistics.service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.toulios.leaguestatistics.model.League;
import com.toulios.leaguestatistics.model.NewTeamInfo;
import com.toulios.leaguestatistics.model.Players;
import com.toulios.leaguestatistics.model.Team;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewTableCalculatorHelper {

    @Autowired
    RetrievalServiceImpl service;

    /**
     * Intialize the appropriate values for each team in a map with
     * pair (teamId, appropriate_value_for_eachMap)
     *
     * @param teamPoints
     * @param teamPlayers
     * @param teamGoalsScored
     * @param teamGoalsAttempted
     * @param teamPlayersAverageAge
     * @param teamsInfoMap
     */
    protected void initializeTeamsInfo(
            Map<Integer, Integer> teamPoints,
            Map<Integer, Players> teamPlayers,
            Map<Integer, Integer> teamGoalsScored,
            Map<Integer, Integer> teamGoalsAttempted,
            Map<Integer, Double> teamPlayersAverageAge,
            Map<Integer, Team> teamsInfoMap) {

        League league = service.retrieveLeague();
        if(league != null) {
            calculateTeamsInfo(teamPoints, teamPlayers, teamGoalsScored, teamGoalsAttempted, teamPlayersAverageAge, teamsInfoMap, league);
        }
    }

    /**
     * Calculates the appropriate values for each team
     *
     * @param teamPoints
     * @param teamPlayers
     * @param teamGoalsScored
     * @param teamGoalsAttempted
     * @param teamPlayersAverageAge
     * @param teamsInfoMap
     * @param league
     */
    private void calculateTeamsInfo(Map<Integer, Integer> teamPoints, Map<Integer, Players> teamPlayers, Map<Integer, Integer> teamGoalsScored, Map<Integer, Integer> teamGoalsAttempted, Map<Integer, Double> teamPlayersAverageAge, Map<Integer, Team> teamsInfoMap, League league) {
        Integer groupId = retrieveGroupIdFromFirstLeagueDataEntry(league);
        league.getData()
                .get(0)
                .getGroups().getData()
                .stream()
                    .filter(groupDataInfo -> groupDataInfo.getId().equals(groupId))
                    .findFirst()
                    .get()
                    .getTeams()
                    .getData()
                        .forEach(teamInfo -> {
                            Integer teamId = teamInfo.getTeamId();
                            teamPlayers.put(teamId, service.retrievePlayers(teamInfo.getTeamId()));
                            teamGoalsScored.put(teamId, teamInfo.getOverallGoalsScored());
                            teamPoints.put(teamId, teamInfo.getPoints());
                            teamGoalsAttempted.put(teamId, teamInfo.getOverallGoalsAttempted());
                            teamsInfoMap.put(teamId, teamInfo.getTeam());
                        });

        calculateAverageAgePerTeam(teamPlayers, teamPlayersAverageAge);
    }

    /**
     * Retrieve the group Id from the first league data entry
     *
     * @param league
     * @return
     */
    private Integer retrieveGroupIdFromFirstLeagueDataEntry(League league) {
        return league.getData().get(0).getStandings().getData().get(0).getGroupId();
    }

    /**
     * Calculates the average age of each team in days
     *
     * @param teamPlayers
     * @param teamPlayersAverageAge
     */
    private void calculateAverageAgePerTeam(Map<Integer, Players> teamPlayers, Map<Integer, Double> teamPlayersAverageAge) {
        teamPlayers.forEach( (teamId, players) ->{
            int sumOfPlayers = players.getData().size();
            int sumOfPlayersAge = players.getData()
            		.stream()
            		.filter(playerInfo->  StringUtils.isNotEmpty(playerInfo.getBirthDate()))
            		.mapToInt(
            				playerVal -> getAgeInDays(playerVal.getBirthDate()))
            		.sum();
            teamPlayersAverageAge.put(teamId, (double)sumOfPlayersAge/(double)sumOfPlayers);
        });
    }

    /**
     * Calculates the average age of all the players in league
     *
     * @param teamPlayers
     * @return
     */
    protected double calculateAverageAgeOfAllTeams(Map<Integer, Players> teamPlayers) {

        Integer totalPlayers = teamPlayers.values()
                .stream()
                .mapToInt(playersVal -> playersVal.getData().size())
                .sum();

        Integer totalAge = teamPlayers.values()
                .stream()
                .mapToInt(playersInfoValue -> playersInfoValue.getData()
                        .stream()
                        .filter(playerInfo->  StringUtils.isNotEmpty(playerInfo.getBirthDate()))
                        .mapToInt(eachPlayerInfo -> getAgeInDays(eachPlayerInfo.getBirthDate()))
                        .sum())
                .sum();

        return totalAge.doubleValue()/totalPlayers.doubleValue();
    }

    /**
     * Calculates the days from the specified date until now in days
     *
     * @param date
     * @return
     */
    private Integer getAgeInDays(String date) {
    	
    	DateTimeFormatter datetimeFormater = DateTimeFormat.forPattern("yyyy-MM-dd");
        LocalDate playerDate = datetimeFormater.parseLocalDate(date);
        LocalDate now = LocalDate.now();
               
        return Days.daysBetween(playerDate, now).getDays();
    }

    /**
     * Calculates the new points for all the teams
     *
     * @param teamPoints
     * @param teamGoalsScored
     * @param teamGoalsAttempted
     * @param teamPlayersAverageAge
     * @param teamNewPoints
     * @param averageAgeOfAllTeams
     */
    protected void calculateNewPointsTable(Map<Integer, Integer> teamPoints, Map<Integer, Integer> teamGoalsScored, Map<Integer, Integer> teamGoalsAttempted, Map<Integer, Double> teamPlayersAverageAge, Map<Integer, Double> teamNewPoints, Double averageAgeOfAllTeams) {

        teamPoints.forEach((teamId, points) -> teamNewPoints
                .put(
                        teamId,
                        calculateNewPoints(
                                points,
                                teamGoalsScored.get(teamId),
                                teamGoalsAttempted.get(teamId),
                                teamPlayersAverageAge.get(teamId),
                                averageAgeOfAllTeams
                        )
                )
        );

    }

    /**
     * Calculates the new points for each teamm
     *
     * @param points
     * @param goals_scored
     * @param goals_conceded
     * @param average_age_of_team_in_days
     * @param average_age_of_all_players_in_league_in_days
     * @return
     */
    private double calculateNewPoints(Integer points, Integer goals_scored, Integer goals_conceded, Double average_age_of_team_in_days,Double average_age_of_all_players_in_league_in_days){
        double value = points * ((double)goals_scored / (double)goals_conceded) * (average_age_of_team_in_days/average_age_of_all_players_in_league_in_days);
        return new BigDecimal(value).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * Sort the teams according to new points system
     *
     * @param teamNewPoints
     * @return
     */
    protected Map<Integer, Double> sortNewPointsTable(Map<Integer, Double> teamNewPoints) {

        return teamNewPoints
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(
                        Collectors
                                .toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                                )
                );
    }

    /**
     * Initialize the talbe with the new systems points
     *
     * @param teamNewPoints
     * @param teamsInfo
     * @param newTableTeamsInfo
     */
    protected void initializeNewTalbeTeamsInfo(Map<Integer, Double> teamNewPoints, Map<Integer, Team> teamsInfo, List<NewTeamInfo> newTableTeamsInfo) {

        int position = 1;
        for(Map.Entry<Integer, Double> teamInfo: teamNewPoints.entrySet()){
            initializeEachTeamNewInfo(teamsInfo, newTableTeamsInfo, position, teamInfo);
            position++;
        }
    }

    /**
     * Initialize the information for each team with the new points system
     *
     * @param teamsInfo
     * @param newTableTeamsInfo
     * @param position
     * @param teamInfo
     */
    private void initializeEachTeamNewInfo(Map<Integer, Team> teamsInfo, List<NewTeamInfo> newTableTeamsInfo, int position, Map.Entry<Integer, Double> teamInfo) {
        NewTeamInfo info = new NewTeamInfo();
        info.setNewSystemPoints(teamInfo.getValue());
        info.setName(teamsInfo.get(teamInfo.getKey()).getName());
        info.setPosition(position);
        newTableTeamsInfo.add(info);
    }

    /**
     * Calculate how many vowels have each team's name
     *
     * @param teamsInfo
     * @param teamsNameVowels
     */
    public void calculateTeamNameVowels(Map<Integer, Team> teamsInfo, Map<String, Integer> teamsNameVowels) {
        teamsInfo.forEach( (teamId, teamInfo) -> teamsNameVowels.put(teamInfo.getName(), calculateNumOfVowels(teamInfo.getName())));
    }

    /**
     * Calculates the vowels of a string
     *
     * @param name
     * @return
     */
    private Integer calculateNumOfVowels(String name){
        return name.length() - name.toLowerCase().replaceAll("a|e|i|o|u|", "").length();
    }

    /**
     * Sort the new table by the number of each team's name for teams where they have equal points
     *
     * @param newTableTeamsInfo
     * @param teamsNameVowels
     */
    public void sortNewTableByVowels(List<NewTeamInfo> newTableTeamsInfo, Map<String, Integer> teamsNameVowels) {

        for(int i=0;i< newTableTeamsInfo.size();i++){
            for(int j=i;j<newTableTeamsInfo.size();j++){
                boolean hasEqualsPoints = newTableTeamsInfo.get(i).getNewSystemPoints() == newTableTeamsInfo.get(j).getNewSystemPoints();
                if(hasEqualsPoints){
                    if(teamsNameVowels.get(newTableTeamsInfo.get(i).getName()) < teamsNameVowels.get(newTableTeamsInfo.get(j).getName())) {
                        swapPositions(newTableTeamsInfo, i, j);
                    }
                }
            }
        }

    }

    /**
     * Swap the value of team's position
     *
     * @param newTableTeamsInfo
     * @param i
     * @param j
     */
    private void swapPositions(List<NewTeamInfo> newTableTeamsInfo, int i, int j) {
        int tempPos = newTableTeamsInfo.get(i).getPosition();
        newTableTeamsInfo.get(i).setPosition(newTableTeamsInfo.get(j).getPosition());
        newTableTeamsInfo.get(j).setPosition(tempPos);
    }
}
