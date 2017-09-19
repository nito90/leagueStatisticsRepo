
package com.toulios.leaguestatistics.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupDataInfo implements Serializable
{

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("teams")
    private Teams teams;
    
    private final static long serialVersionUID = -248265220401261502L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GroupDataInfo() {
    }

    /**
     * 
     * @param id
     * @param teams
     * @param name
     */
    public GroupDataInfo(Integer id, String name, Teams teams) {
        super();
        this.id = id;
        this.name = name;
        this.teams = teams;
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

    @JsonProperty("teams")
    public Teams getTeams() {
        return teams;
    }

    @JsonProperty("teams")
    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).append(teams).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GroupDataInfo) == false) {
            return false;
        }
        GroupDataInfo rhs = ((GroupDataInfo) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(teams, rhs.teams).isEquals();
    }

}
