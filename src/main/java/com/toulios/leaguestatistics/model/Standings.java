
package com.toulios.leaguestatistics.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Standings implements Serializable
{

    @JsonProperty("data")
    private List<StandingsDataInfo> data = null;
    private final static long serialVersionUID = -6110672368194564034L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Standings() {
    }

    /**
     * 
     * @param data
     */
    public Standings(List<StandingsDataInfo> data) {
        super();
        this.data = data;
    }

    @JsonProperty("data")
    public List<StandingsDataInfo> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<StandingsDataInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(data).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Standings) == false) {
            return false;
        }
        Standings rhs = ((Standings) other);
        return new EqualsBuilder().append(data, rhs.data).isEquals();
    }

}
