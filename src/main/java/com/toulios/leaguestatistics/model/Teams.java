
package com.toulios.leaguestatistics.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Teams implements Serializable
{

    @JsonProperty("data")
    private List<GroupTeamsDataInfo> data = null;
    private final static long serialVersionUID = -6725981248441192702L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Teams() {
    }

    /**
     * 
     * @param data
     */
    public Teams(List<GroupTeamsDataInfo> data) {
        super();
        this.data = data;
    }

    @JsonProperty("data")
    public List<GroupTeamsDataInfo> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<GroupTeamsDataInfo> data) {
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
        if ((other instanceof Teams) == false) {
            return false;
        }
        Teams rhs = ((Teams) other);
        return new EqualsBuilder().append(data, rhs.data).isEquals();
    }

}
