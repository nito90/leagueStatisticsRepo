
package com.toulios.leaguestatistics.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "team_id",
    "current_round_name",
    "current_round_id",
    "position",
    "points",
    "overall_win",
    "overall_draw",
    "overall_loose",
    "overall_played",
    "overall_goals_attempted",
    "overall_goals_scored",
    "home_win",
    "home_draw",
    "home_loose",
    "home_played",
    "home_goals_attempted",
    "home_goals_scored",
    "away_win",
    "away_draw",
    "away_loose",
    "away_played",
    "away_goals_attempted",
    "away_goals_scored",
    "goal_difference",
    "status",
    "recent_form",
    "result",
    "team"
})
public class GroupTeamsDataInfo implements Serializable
{

    @JsonProperty("team_id")
    private Integer teamId;
    @JsonProperty("current_round_name")
    private Integer currentRoundName;
    @JsonProperty("current_round_id")
    private Integer currentRoundId;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("points")
    private Integer points;
    @JsonProperty("overall_win")
    private Integer overallWin;
    @JsonProperty("overall_draw")
    private Integer overallDraw;
    @JsonProperty("overall_loose")
    private Integer overallLoose;
    @JsonProperty("overall_played")
    private Integer overallPlayed;
    @JsonProperty("overall_goals_attempted")
    private Integer overallGoalsAttempted;
    @JsonProperty("overall_goals_scored")
    private Integer overallGoalsScored;
    @JsonProperty("home_win")
    private Integer homeWin;
    @JsonProperty("home_draw")
    private Integer homeDraw;
    @JsonProperty("home_loose")
    private Integer homeLoose;
    @JsonProperty("home_played")
    private Integer homePlayed;
    @JsonProperty("home_goals_attempted")
    private Integer homeGoalsAttempted;
    @JsonProperty("home_goals_scored")
    private Integer homeGoalsScored;
    @JsonProperty("away_win")
    private Integer awayWin;
    @JsonProperty("away_draw")
    private Integer awayDraw;
    @JsonProperty("away_loose")
    private Integer awayLoose;
    @JsonProperty("away_played")
    private Integer awayPlayed;
    @JsonProperty("away_goals_attempted")
    private Integer awayGoalsAttempted;
    @JsonProperty("away_goals_scored")
    private Integer awayGoalsScored;
    @JsonProperty("goal_difference")
    private Integer goalDifference;
    @JsonProperty("status")
    private String status;
    @JsonProperty("recent_form")
    private String recentForm;
    @JsonProperty("result")
    private String result;
    @JsonProperty("team")
    private Team team;
   
    private final static long serialVersionUID = -2686657469245858143L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GroupTeamsDataInfo() {
    }

    /**
     * 
     * @param position
     * @param result
     * @param recentForm
     * @param homeLoose
     * @param teamId
     * @param awayGoalsScored
     * @param goalDifference
     * @param points
     * @param awayPlayed
     * @param overallLoose
     * @param homeGoalsAttempted
     * @param homeDraw
     * @param currentRoundId
     * @param overallDraw
     * @param status
     * @param awayLoose
     * @param team
     * @param homeWin
     * @param homePlayed
     * @param overallGoalsScored
     * @param awayDraw
     * @param awayGoalsAttempted
     * @param currentRoundName
     * @param homeGoalsScored
     * @param awayWin
     * @param overallWin
     * @param overallPlayed
     * @param overallGoalsAttempted
     */
    public GroupTeamsDataInfo(Integer teamId, Integer currentRoundName, Integer currentRoundId, Integer position, Integer points, Integer overallWin, Integer overallDraw, Integer overallLoose, Integer overallPlayed, Integer overallGoalsAttempted, Integer overallGoalsScored, Integer homeWin, Integer homeDraw, Integer homeLoose, Integer homePlayed, Integer homeGoalsAttempted, Integer homeGoalsScored, Integer awayWin, Integer awayDraw, Integer awayLoose, Integer awayPlayed, Integer awayGoalsAttempted, Integer awayGoalsScored, Integer goalDifference, String status, String recentForm, String result, Team team) {
        super();
        this.teamId = teamId;
        this.currentRoundName = currentRoundName;
        this.currentRoundId = currentRoundId;
        this.position = position;
        this.points = points;
        this.overallWin = overallWin;
        this.overallDraw = overallDraw;
        this.overallLoose = overallLoose;
        this.overallPlayed = overallPlayed;
        this.overallGoalsAttempted = overallGoalsAttempted;
        this.overallGoalsScored = overallGoalsScored;
        this.homeWin = homeWin;
        this.homeDraw = homeDraw;
        this.homeLoose = homeLoose;
        this.homePlayed = homePlayed;
        this.homeGoalsAttempted = homeGoalsAttempted;
        this.homeGoalsScored = homeGoalsScored;
        this.awayWin = awayWin;
        this.awayDraw = awayDraw;
        this.awayLoose = awayLoose;
        this.awayPlayed = awayPlayed;
        this.awayGoalsAttempted = awayGoalsAttempted;
        this.awayGoalsScored = awayGoalsScored;
        this.goalDifference = goalDifference;
        this.status = status;
        this.recentForm = recentForm;
        this.result = result;
        this.team = team;
    }

    @JsonProperty("team_id")
    public Integer getTeamId() {
        return teamId;
    }

    @JsonProperty("team_id")
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("current_round_name")
    public Integer getCurrentRoundName() {
        return currentRoundName;
    }

    @JsonProperty("current_round_name")
    public void setCurrentRoundName(Integer currentRoundName) {
        this.currentRoundName = currentRoundName;
    }

    @JsonProperty("current_round_id")
    public Integer getCurrentRoundId() {
        return currentRoundId;
    }

    @JsonProperty("current_round_id")
    public void setCurrentRoundId(Integer currentRoundId) {
        this.currentRoundId = currentRoundId;
    }

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position) {
        this.position = position;
    }

    @JsonProperty("points")
    public Integer getPoints() {
        return points;
    }

    @JsonProperty("points")
    public void setPoints(Integer points) {
        this.points = points;
    }

    @JsonProperty("overall_win")
    public Integer getOverallWin() {
        return overallWin;
    }

    @JsonProperty("overall_win")
    public void setOverallWin(Integer overallWin) {
        this.overallWin = overallWin;
    }

    @JsonProperty("overall_draw")
    public Integer getOverallDraw() {
        return overallDraw;
    }

    @JsonProperty("overall_draw")
    public void setOverallDraw(Integer overallDraw) {
        this.overallDraw = overallDraw;
    }

    @JsonProperty("overall_loose")
    public Integer getOverallLoose() {
        return overallLoose;
    }

    @JsonProperty("overall_loose")
    public void setOverallLoose(Integer overallLoose) {
        this.overallLoose = overallLoose;
    }

    @JsonProperty("overall_played")
    public Integer getOverallPlayed() {
        return overallPlayed;
    }

    @JsonProperty("overall_played")
    public void setOverallPlayed(Integer overallPlayed) {
        this.overallPlayed = overallPlayed;
    }

    @JsonProperty("overall_goals_attempted")
    public Integer getOverallGoalsAttempted() {
        return overallGoalsAttempted;
    }

    @JsonProperty("overall_goals_attempted")
    public void setOverallGoalsAttempted(Integer overallGoalsAttempted) {
        this.overallGoalsAttempted = overallGoalsAttempted;
    }

    @JsonProperty("overall_goals_scored")
    public Integer getOverallGoalsScored() {
        return overallGoalsScored;
    }

    @JsonProperty("overall_goals_scored")
    public void setOverallGoalsScored(Integer overallGoalsScored) {
        this.overallGoalsScored = overallGoalsScored;
    }

    @JsonProperty("home_win")
    public Integer getHomeWin() {
        return homeWin;
    }

    @JsonProperty("home_win")
    public void setHomeWin(Integer homeWin) {
        this.homeWin = homeWin;
    }

    @JsonProperty("home_draw")
    public Integer getHomeDraw() {
        return homeDraw;
    }

    @JsonProperty("home_draw")
    public void setHomeDraw(Integer homeDraw) {
        this.homeDraw = homeDraw;
    }

    @JsonProperty("home_loose")
    public Integer getHomeLoose() {
        return homeLoose;
    }

    @JsonProperty("home_loose")
    public void setHomeLoose(Integer homeLoose) {
        this.homeLoose = homeLoose;
    }

    @JsonProperty("home_played")
    public Integer getHomePlayed() {
        return homePlayed;
    }

    @JsonProperty("home_played")
    public void setHomePlayed(Integer homePlayed) {
        this.homePlayed = homePlayed;
    }

    @JsonProperty("home_goals_attempted")
    public Integer getHomeGoalsAttempted() {
        return homeGoalsAttempted;
    }

    @JsonProperty("home_goals_attempted")
    public void setHomeGoalsAttempted(Integer homeGoalsAttempted) {
        this.homeGoalsAttempted = homeGoalsAttempted;
    }

    @JsonProperty("home_goals_scored")
    public Integer getHomeGoalsScored() {
        return homeGoalsScored;
    }

    @JsonProperty("home_goals_scored")
    public void setHomeGoalsScored(Integer homeGoalsScored) {
        this.homeGoalsScored = homeGoalsScored;
    }

    @JsonProperty("away_win")
    public Integer getAwayWin() {
        return awayWin;
    }

    @JsonProperty("away_win")
    public void setAwayWin(Integer awayWin) {
        this.awayWin = awayWin;
    }

    @JsonProperty("away_draw")
    public Integer getAwayDraw() {
        return awayDraw;
    }

    @JsonProperty("away_draw")
    public void setAwayDraw(Integer awayDraw) {
        this.awayDraw = awayDraw;
    }

    @JsonProperty("away_loose")
    public Integer getAwayLoose() {
        return awayLoose;
    }

    @JsonProperty("away_loose")
    public void setAwayLoose(Integer awayLoose) {
        this.awayLoose = awayLoose;
    }

    @JsonProperty("away_played")
    public Integer getAwayPlayed() {
        return awayPlayed;
    }

    @JsonProperty("away_played")
    public void setAwayPlayed(Integer awayPlayed) {
        this.awayPlayed = awayPlayed;
    }

    @JsonProperty("away_goals_attempted")
    public Integer getAwayGoalsAttempted() {
        return awayGoalsAttempted;
    }

    @JsonProperty("away_goals_attempted")
    public void setAwayGoalsAttempted(Integer awayGoalsAttempted) {
        this.awayGoalsAttempted = awayGoalsAttempted;
    }

    @JsonProperty("away_goals_scored")
    public Integer getAwayGoalsScored() {
        return awayGoalsScored;
    }

    @JsonProperty("away_goals_scored")
    public void setAwayGoalsScored(Integer awayGoalsScored) {
        this.awayGoalsScored = awayGoalsScored;
    }

    @JsonProperty("goal_difference")
    public Integer getGoalDifference() {
        return goalDifference;
    }

    @JsonProperty("goal_difference")
    public void setGoalDifference(Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("recent_form")
    public String getRecentForm() {
        return recentForm;
    }

    @JsonProperty("recent_form")
    public void setRecentForm(String recentForm) {
        this.recentForm = recentForm;
    }

    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(String result) {
        this.result = result;
    }

    @JsonProperty("team")
    public Team getTeam() {
        return team;
    }

    @JsonProperty("team")
    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(teamId).append(currentRoundName).append(currentRoundId).append(position).append(points).append(overallWin).append(overallDraw).append(overallLoose).append(overallPlayed).append(overallGoalsAttempted).append(overallGoalsScored).append(homeWin).append(homeDraw).append(homeLoose).append(homePlayed).append(homeGoalsAttempted).append(homeGoalsScored).append(awayWin).append(awayDraw).append(awayLoose).append(awayPlayed).append(awayGoalsAttempted).append(awayGoalsScored).append(goalDifference).append(status).append(recentForm).append(result).append(team).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GroupTeamsDataInfo) == false) {
            return false;
        }
        GroupTeamsDataInfo rhs = ((GroupTeamsDataInfo) other);
        return new EqualsBuilder().append(teamId, rhs.teamId).append(currentRoundName, rhs.currentRoundName).append(currentRoundId, rhs.currentRoundId).append(position, rhs.position).append(points, rhs.points).append(overallWin, rhs.overallWin).append(overallDraw, rhs.overallDraw).append(overallLoose, rhs.overallLoose).append(overallPlayed, rhs.overallPlayed).append(overallGoalsAttempted, rhs.overallGoalsAttempted).append(overallGoalsScored, rhs.overallGoalsScored).append(homeWin, rhs.homeWin).append(homeDraw, rhs.homeDraw).append(homeLoose, rhs.homeLoose).append(homePlayed, rhs.homePlayed).append(homeGoalsAttempted, rhs.homeGoalsAttempted).append(homeGoalsScored, rhs.homeGoalsScored).append(awayWin, rhs.awayWin).append(awayDraw, rhs.awayDraw).append(awayLoose, rhs.awayLoose).append(awayPlayed, rhs.awayPlayed).append(awayGoalsAttempted, rhs.awayGoalsAttempted).append(awayGoalsScored, rhs.awayGoalsScored).append(goalDifference, rhs.goalDifference).append(status, rhs.status).append(recentForm, rhs.recentForm).append(result, rhs.result).append(team, rhs.team).isEquals();
    }

}
