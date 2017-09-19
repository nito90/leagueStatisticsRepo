
package com.toulios.leaguestatistics.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerInfo implements Serializable
{

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("shirt_number")
    private Object shirtNumber;
    @JsonProperty("fullname")
    private Object fullname;
    @JsonProperty("nationality")
    private Object nationality;
    @JsonProperty("birth_country")
    private String birthCountry;
    @JsonProperty("birth_date")
    private String birthDate;
    @JsonProperty("birth_place")
    private String birthPlace;
    @JsonProperty("height")
    private Object height;
    @JsonProperty("weight")
    private String weight;
    @JsonProperty("photo")
    private Object photo;
    
    private final static long serialVersionUID = -76955913609605540L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlayerInfo() {
    }

    /**
     * 
     * @param id
     * @param weight
     * @param height
     * @param nationality
     * @param birthCountry
     * @param shirtNumber
     * @param name
     * @param birthDate
     * @param photo
     * @param birthPlace
     * @param fullname
     */
    public PlayerInfo(Integer id, String name, Object shirtNumber, Object fullname, Object nationality, String birthCountry, String birthDate, String birthPlace, Object height, String weight, Object photo) {
        super();
        this.id = id;
        this.name = name;
        this.shirtNumber = shirtNumber;
        this.fullname = fullname;
        this.nationality = nationality;
        this.birthCountry = birthCountry;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.height = height;
        this.weight = weight;
        this.photo = photo;
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

    @JsonProperty("shirt_number")
    public Object getShirtNumber() {
        return shirtNumber;
    }

    @JsonProperty("shirt_number")
    public void setShirtNumber(Object shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    @JsonProperty("fullname")
    public Object getFullname() {
        return fullname;
    }

    @JsonProperty("fullname")
    public void setFullname(Object fullname) {
        this.fullname = fullname;
    }

    @JsonProperty("nationality")
    public Object getNationality() {
        return nationality;
    }

    @JsonProperty("nationality")
    public void setNationality(Object nationality) {
        this.nationality = nationality;
    }

    @JsonProperty("birth_country")
    public String getBirthCountry() {
        return birthCountry;
    }

    @JsonProperty("birth_country")
    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    @JsonProperty("birth_date")
    public String getBirthDate() {
        return birthDate;
    }

    @JsonProperty("birth_date")
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @JsonProperty("birth_place")
    public String getBirthPlace() {
        return birthPlace;
    }

    @JsonProperty("birth_place")
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @JsonProperty("height")
    public Object getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Object height) {
        this.height = height;
    }

    @JsonProperty("weight")
    public String getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(String weight) {
        this.weight = weight;
    }

    @JsonProperty("photo")
    public Object getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).append(shirtNumber).append(fullname).append(nationality).append(birthCountry).append(birthDate).append(birthPlace).append(height).append(weight).append(photo).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PlayerInfo) == false) {
            return false;
        }
        PlayerInfo rhs = ((PlayerInfo) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(shirtNumber, rhs.shirtNumber).append(fullname, rhs.fullname).append(nationality, rhs.nationality).append(birthCountry, rhs.birthCountry).append(birthDate, rhs.birthDate).append(birthPlace, rhs.birthPlace).append(height, rhs.height).append(weight, rhs.weight).append(photo, rhs.photo).isEquals();
    }

}
