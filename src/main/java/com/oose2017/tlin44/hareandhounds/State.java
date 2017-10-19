package com.oose2017.tlin44.hareandhounds;

/**
 * To store the state status
 * @author Tianyi Lin
 *
 */
public class State {
	
	String state;
	String gameId;



	/**
	 * The constructor for persist across server restarts
	 * @param gameId
	 * @param state
	 */
	public State(String gameId, String state) {
		this.state = state;
		this.gameId = gameId;
	}


	/**
	 * constructor
	 * state should always be "WAITING_FOR_SECOND_PLAYER"
	 * @param gameId
	 */
	public State(String gameId) {
		this.state = "WAITING_FOR_SECOND_PLAYER";
		this.gameId = gameId;
	}

	
	
	/**
	 * no matter which type the joiner choose, just let Hound go first
	 * set the state as turn hound 
	 */
	public void is_Hound_Turn() {
		state = "TURN_HOUND";
	}
	
	/**
	 * set the state as turn hare
	 */
	public void is_Hare_Turn() {
		state = "TURN_HARE";
	}
	
	/**
	 * set the state as hound win
	 */
	public void win_Hound(){
		state = "WIN_HOUND";
	}
	
	/**
	 * set the state as hare win by escape
	 */
	public void win_HareEscape(){
		state = "WIN_HARE_BY_ESCAPE";
	}
	
	/**
	 * set the state as hare win by stalling 
	 */
	public void win_HareStalling(){
		state = "WIN_HARE_BY_STALLING";
	}
	
}
