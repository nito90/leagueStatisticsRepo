package com.toulios.leaguestatistics.web.mgmt;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.toulios.leaguestatistics.api.Response;
import com.toulios.leaguestatistics.exceptions.RetrievalValidationException;
import com.toulios.leaguestatistics.model.League;
import com.toulios.leaguestatistics.model.NewLeagueTable;
import com.toulios.leaguestatistics.model.Players;
import com.toulios.leaguestatistics.service.NewTableCalculatorImpl;
import com.toulios.leaguestatistics.service.RetrievalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/leagues")
public class LeagueStatisticsController {

	@Autowired
	private RetrievalServiceImpl service;

	@Autowired
	private NewTableCalculatorImpl calculator;

	@ApiResponses({
		@ApiResponse(code = 200, message = "Returns the scotish league info"),
		@ApiResponse(code = 400, message = "Problem with request."),
	})
	@RequestMapping(value = "/retrieve/scotish", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public League retrieveScotishStandings() {
		League result = service.retrieveLeague();
		if(result == null) {
			throw new RetrievalValidationException("Validation error.");
		}
		return result;
	}
	
	@ApiResponses({
		@ApiResponse(code = 200, message = "Returns the players for the specified team Id"),
		@ApiResponse(code = 400, message = "Problem with request."),
	})
	@RequestMapping(value = "/retrieve/scotish/team/{id}/players", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public Players retrievePlayers(@PathVariable Integer id) {
		Players result = service.retrievePlayers(id);
		if(result == null) {
			throw new RetrievalValidationException("Validation error.");
		}
		return result;
	}

	@ApiResponses({
			@ApiResponse(code = 200, message = "Returns the new Table with the new points system"),
			@ApiResponse(code = 400, message = "Problem with request."),
	})
	@RequestMapping(value = "/retrieve/scotish/new/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public NewLeagueTable retrievePlayers() {
		return calculator.calculateNewScotishLeagueTable();
	}
	
	@ExceptionHandler(RetrievalValidationException.class)
	public Response invalid(Exception e, HttpServletResponse response) throws IOException {
		return new Response(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}
	
}
