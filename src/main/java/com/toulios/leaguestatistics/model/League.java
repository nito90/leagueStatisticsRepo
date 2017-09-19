
package com.toulios.leaguestatistics.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class League implements Serializable
{

    @JsonProperty("data")
    private List<LeagueDataInfo> data = null;
    
    private final static long serialVersionUID = -2404320971905364136L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public League() {
    }

    /**
     * 
     * @param data
     */
    public League(List<LeagueDataInfo> data) {
        super();
        this.data = data;
    }

    @JsonProperty("data")
    public List<LeagueDataInfo> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<LeagueDataInfo> data) {
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
        if ((other instanceof League) == false) {
            return false;
        }
        League rhs = ((League) other);
        return new EqualsBuilder().append(data, rhs.data).isEquals();
    }

}
