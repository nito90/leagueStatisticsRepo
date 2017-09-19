
package com.toulios.leaguestatistics.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Team implements Serializable
{

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("twitter")
    private String twitter;
    @JsonProperty("venue_id")
    private Object venueId;
    @JsonProperty("coach_id")
    private Object coachId;
    @JsonProperty("chairman_id")
    private Object chairmanId;
   
    private final static long serialVersionUID = 7673283924106927323L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Team() {
    }

    /**
     * 
     * @param id
     * @param twitter
     * @param logo
     * @param coachId
     * @param chairmanId
     * @param name
     * @param venueId
     */
    public Team(Integer id, String name, String logo, String twitter, Object venueId, Object coachId, Object chairmanId) {
        super();
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.twitter = twitter;
        this.venueId = venueId;
        this.coachId = coachId;
        this.chairmanId = chairmanId;
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

    @JsonProperty("logo")
    public String getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(String logo) {
        this.logo = logo;
    }

    @JsonProperty("twitter")
    public String getTwitter() {
        return twitter;
    }

    @JsonProperty("twitter")
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @JsonProperty("venue_id")
    public Object getVenueId() {
        return venueId;
    }

    @JsonProperty("venue_id")
    public void setVenueId(Object venueId) {
        this.venueId = venueId;
    }

    @JsonProperty("coach_id")
    public Object getCoachId() {
        return coachId;
    }

    @JsonProperty("coach_id")
    public void setCoachId(Object coachId) {
        this.coachId = coachId;
    }

    @JsonProperty("chairman_id")
    public Object getChairmanId() {
        return chairmanId;
    }

    @JsonProperty("chairman_id")
    public void setChairmanId(Object chairmanId) {
        this.chairmanId = chairmanId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).append(logo).append(twitter).append(venueId).append(coachId).append(chairmanId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Team) == false) {
            return false;
        }
        Team rhs = ((Team) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(logo, rhs.logo).append(twitter, rhs.twitter).append(venueId, rhs.venueId).append(coachId, rhs.coachId).append(chairmanId, rhs.chairmanId).isEquals();
    }

}
