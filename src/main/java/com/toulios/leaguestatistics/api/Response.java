package com.toulios.leaguestatistics.api;

import java.io.Serializable;

/* 
* Representation of a request's response
*
*/
public class Response implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4353861402915739983L;

	/**
	 * The http code of the result
	 */
	private final int result;
	
	/**
	 * The description of the result
	 */
	private final String description;

	public Response(int result, String description) {
		this.result = result;
		this.description = description;
	}

	public int getResult() {
		return this.result;
	}

	public String getDescription() {
		return this.description;
	}

}
