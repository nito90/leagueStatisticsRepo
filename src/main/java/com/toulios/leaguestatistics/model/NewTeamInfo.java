package com.toulios.leaguestatistics.model;

import java.io.Serializable;


public class NewTeamInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5091440310836397491L;

	private String name;
	private Double newSystemPoints;
	private Integer position;
	
	public NewTeamInfo() {
		super();
	}
	
	public NewTeamInfo(String name, Double newSystemPoints, Integer position) {
		this.name = name;
		this.newSystemPoints = newSystemPoints;
		this.position = position;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getNewSystemPoints() {
		return newSystemPoints;
	}
	public void setNewSystemPoints(Double newSystemPoints) {
		this.newSystemPoints = newSystemPoints;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
}
