package com.toulios.leaguestatistics.model;

import java.io.Serializable;
import java.util.List;

public class NewLeagueTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2948192153624907581L;
	
	private String leagueName;
	private List<NewTeamInfo> table;
	
	
	public NewLeagueTable() {
		super();
	}
	
	public NewLeagueTable(String leagueName, List<NewTeamInfo> table) {
		this.leagueName = leagueName;
		this.table = table;
	}
	
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public List<NewTeamInfo> getTable() {
		return table;
	}
	public void setTable(List<NewTeamInfo> table) {
		this.table = table;
	}
	
	
}
