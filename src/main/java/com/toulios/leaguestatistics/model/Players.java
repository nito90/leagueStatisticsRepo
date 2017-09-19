
package com.toulios.leaguestatistics.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Players implements Serializable
{

    @JsonProperty("data")
    private List<PlayerInfo> data = null;
  
    private final static long serialVersionUID = -2404320971905364136L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Players() {
    }

    /**
     * 
     * @param data
     */
    public Players(List<PlayerInfo> data) {
        super();
        this.data = data;
    }

    @JsonProperty("data")
    public List<PlayerInfo> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<PlayerInfo> data) {
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
        if ((other instanceof Players) == false) {
            return false;
        }
        Players rhs = ((Players) other);
        return new EqualsBuilder().append(data, rhs.data).isEquals();
    }

}
