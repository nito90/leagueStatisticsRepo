package com.toulios.leaguestatistics.api;

import com.toulios.leaguestatistics.model.NewLeagueTable;

public interface INewTableCalculator {

	/**
	 * Calculates for the Scotish league the new table
	 *
	 * @return
	 */
	public NewLeagueTable calculateNewScotishLeagueTable();
}
