package com.toulios.leaguestatistics.service;

import com.toulios.leaguestatistics.api.IRetrievalService;
import com.toulios.leaguestatistics.model.League;
import com.toulios.leaguestatistics.model.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RetrievalServiceImpl implements IRetrievalService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${leagues_url}")
	private String standingsUrl;
	
	@Value("${player_url_prefix}")
	private String playersUrlPrefix;
	
	@Value("${player_url_postfix}")
	private String playersUrlPostfix;
	
	@Override
	public Players retrievePlayers(Integer teamId) {
		StringBuilder builder = new StringBuilder();
		builder.append(playersUrlPrefix).append(teamId).append(playersUrlPostfix);
		
		return restTemplate.getForObject(builder.toString(), Players.class);
	}


	@Override
	public League retrieveLeague() {
		return restTemplate.getForObject(standingsUrl, League.class);
	}
	
	

}
