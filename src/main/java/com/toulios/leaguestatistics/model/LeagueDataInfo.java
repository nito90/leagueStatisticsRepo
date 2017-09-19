
package com.toulios.leaguestatistics.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeagueDataInfo implements Serializable
{

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("competition_id")
    private Integer competitionId;
    @JsonProperty("season_id")
    private Integer seasonId;
    @JsonProperty("standings")
    private Standings standings;
    @JsonProperty("groups")
    private Groups groups;
    
    private final static long serialVersionUID = 6350858498948253264L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LeagueDataInfo() {
    }

    /**
     * 
     * @param id
     * @param standings
     * @param name
     * @param seasonId
     * @param competitionId
     * @param groups
     */
    public LeagueDataInfo(Integer id, String name, Integer competitionId, Integer seasonId, Standings standings, Groups groups) {
        super();
        this.id = id;
        this.name = name;
        this.competitionId = competitionId;
        this.seasonId = seasonId;
        this.standings = standings;
        this.groups = groups;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("competition_id")
    public Integer getCompetitionId() {
        return competitionId;
    }

    @JsonProperty("competition_id")
    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    @JsonProperty("season_id")
    public Integer getSeasonId() {
        return seasonId;
    }

    @JsonProperty("season_id")
    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    @JsonProperty("standings")
    public Standings getStandings() {
        return standings;
    }

    @JsonProperty("standings")
    public void setStandings(Standings standings) {
        this.standings = standings;
    }

    @JsonProperty("groups")
    public Groups getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).append(competitionId).append(seasonId).append(standings).append(groups).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LeagueDataInfo) == false) {
            return false;
        }
        LeagueDataInfo rhs = ((LeagueDataInfo) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(competitionId, rhs.competitionId).append(seasonId, rhs.seasonId).append(standings, rhs.standings).append(groups, rhs.groups).isEquals();
    }

}
