package com.toulios.leaguestatistics.service;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import com.toulios.leaguestatistics.api.INewTableCalculator;
import com.toulios.leaguestatistics.model.NewLeagueTable;
import com.toulios.leaguestatistics.model.NewTeamInfo;
import com.toulios.leaguestatistics.model.Players;
import com.toulios.leaguestatistics.model.Team;
import com.toulios.leaguestatistics.service.NewTableCalculatorHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewTableCalculatorImpl implements INewTableCalculator {

	private final static String LEAGUE_NAME = "NIKOS";

	@Autowired
	NewTableCalculatorHelper helper;

	@Override
	public NewLeagueTable calculateNewScotishLeagueTable() {

		Map<Integer, Integer> teamPoints = new HashMap<>();
		Map<Integer, Players>  teamPlayers = new HashMap<>();
		Map<Integer, Integer> teamGoalsScored = new HashMap<>();
		Map<Integer, Integer> teamGoalsAttempted = new HashMap<>();
		Map<Integer, Double> teamPlayersAverageAge = new HashMap<>();
		Map<Integer, Double> teamNewPoints = new HashMap<>();
		Map<Integer, Team> teamsInfo= new HashMap<>();
		Map<String, Integer> teamsNameVowels = new HashMap<>();

		calculateTeamsInformation(teamPoints, teamPlayers, teamGoalsScored, teamGoalsAttempted, teamPlayersAverageAge, teamNewPoints, teamsInfo, teamsNameVowels);
		teamNewPoints = helper.sortNewPointsTable(teamNewPoints);
		return calculateNewTableInfo(teamNewPoints, teamsInfo, teamsNameVowels);
	}

	/**
	 * Calculates with the help of a helper the appropriate values for each team
	 *
	 * @param teamPoints
	 * @param teamPlayers
	 * @param teamGoalsScored
	 * @param teamGoalsAttempted
	 * @param teamPlayersAverageAge
	 * @param teamNewPoints
	 * @param teamsInfo
	 */
	private void calculateTeamsInformation(Map<Integer, Integer> teamPoints, Map<Integer, Players> teamPlayers, Map<Integer, Integer> teamGoalsScored, Map<Integer, Integer> teamGoalsAttempted, Map<Integer, Double> teamPlayersAverageAge, Map<Integer, Double> teamNewPoints, Map<Integer, Team> teamsInfo, Map<String, Integer> teamsNameVowels) {
		helper.initializeTeamsInfo(teamPoints, teamPlayers, teamGoalsScored, teamGoalsAttempted, teamPlayersAverageAge, teamsInfo);
		Double averageAgeOfAllTeams = helper.calculateAverageAgeOfAllTeams(teamPlayers);
		helper.calculateNewPointsTable(teamPoints, teamGoalsScored, teamGoalsAttempted, teamPlayersAverageAge, teamNewPoints, averageAgeOfAllTeams);
		helper.calculateTeamNameVowels(teamsInfo, teamsNameVowels);
	}

	/**
	 * Initialize and return the New table's information
	 *
	 * @param teamNewPoints
	 * @param teamsInfo
	 * @param teamsNameVowels
	 * @return
	 */
	private NewLeagueTable calculateNewTableInfo(Map<Integer, Double> teamNewPoints, Map<Integer, Team> teamsInfo, Map<String, Integer> teamsNameVowels) {
		NewLeagueTable table = new NewLeagueTable();
		table.setLeagueName(LEAGUE_NAME);
		List<NewTeamInfo> newTableTeamsInfo = new ArrayList<>();
		helper.initializeNewTalbeTeamsInfo(teamNewPoints, teamsInfo, newTableTeamsInfo);
		helper.sortNewTableByVowels(newTableTeamsInfo, teamsNameVowels);
		table.setTable(newTableTeamsInfo);
		return table;
	}
}
