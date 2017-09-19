
package com.toulios.leaguestatistics.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Groups implements Serializable
{

    @JsonProperty("data")
    private List<GroupDataInfo> data = null;
    
    private final static long serialVersionUID = -2796159543384710537L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Groups() {
    }

    /**
     * 
     * @param data
     */
    public Groups(List<GroupDataInfo> data) {
        super();
        this.data = data;
    }

    @JsonProperty("data")
    public List<GroupDataInfo> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<GroupDataInfo> data) {
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
        if ((other instanceof Groups) == false) {
            return false;
        }
        Groups rhs = ((Groups) other);
        return new EqualsBuilder().append(data, rhs.data).isEquals();
    }

}
