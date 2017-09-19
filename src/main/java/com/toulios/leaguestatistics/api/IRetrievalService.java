package com.toulios.leaguestatistics.api;


import com.toulios.leaguestatistics.model.League;
import com.toulios.leaguestatistics.model.Players;

public interface IRetrievalService {

	public League retrieveLeague();
	public Players retrievePlayers(Integer teamId);
}
