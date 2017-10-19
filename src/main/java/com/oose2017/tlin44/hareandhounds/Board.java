 package com.oose2017.tlin44.hareandhounds;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * A board class to hold basic board info for each game
 * @author Tianyi Lin
 *
 */
public class Board {

	private final String firstPlayerType;
	private Hashtable<String, Integer> allBoards = new Hashtable<String, Integer>();

	private String gameID;
	private int[][] board;

	/**
	 * Another constructor
	 * @param gameId game id
	 * @param firstPlayerType the player type of the first player
	 * @param hound1_x x of hound1
	 * @param hound1_y y of hound1
	 * @param hound2_x x of hound2
	 * @param hound2_y y of hound2
	 * @param hound3_x x of hound3
	 * @param hound3_y y of hound3
	 * @param hare_x x of hare
	 * @param hare_y y of hare
	 */
	public Board(String gameId, String firstPlayerType, int hound1_x, int hound1_y,
				 int hound2_x, int hound2_y, int  hound3_x, int hound3_y,
				 int hare_x, int hare_y) {
		this.gameID = gameId;
		this.firstPlayerType = firstPlayerType;
		board = new int[3][5];
		board[hound1_x][hound1_y] = 1;
		board[hound2_x][hound2_y] = 1;
		board[hound3_x][hound3_y] = 1;
		board[hare_x][hare_y] = 2;

	}


	/**
	 * Constructor, which can build the initial board position
	 * Make hound 1, and hare 2, 0 represents empty position
	 * @param gameId game id
	 * @param firstPlayerType record the type of first player, which is choose before the user start the game
	 */
	public Board(String gameId, String firstPlayerType) {
		board = new int[3][5];
		board[1][0] = 1;
		board[0][1] = 1;
		board[2][1] = 1;
		board[1][4] = 2;
		this.gameID = gameId;
		this.firstPlayerType = firstPlayerType;
	}


	/**
	 * get number of same boards as a hash table
	 * @return a hash table which contains how many times each board position appears
	 */
	public Hashtable<String, Integer> getBoards() {
		return allBoards;
	}

	/**
	 * get first player type
	 * @return first player type
	 */
	public String getFirstPlayerType() {
		return firstPlayerType;
	}

	/**
	 * @return a hash string
	 */
	public String getHashString() {
		return Arrays.deepToString(getBoard());
	}

	/**
	 * Get board positions info
	 * @return positions info
	 */
	public int[][] getBoard() {
		return board;
	}


	/**
	 * return the different type from first player
	 * @return return "Hare" if first is "HOUND", return "HOUND" if first is "HARE"
	 */
	public String getSecondPlayerType() {
		if(firstPlayerType.equals("HOUND")){
			return "HARE";
		} else {
			return "HOUND";
		}
	}

	/**
	 * move the piece on the board
	 * @param fromX the x-coordinate of start point
	 * @param fromY the y-coordinate of start point
	 * @param toX the x-coordinate of destination
	 * @param toY the y-coordinate of destination
	 * @param value indicates it is hare or hound
	 */
	public void move(int fromX, int fromY, int toX, int toY, int value) {
		board[fromX][fromY] = 0;
		board[toX][toY] = value;

		if(allBoards.containsKey(getHashString())){
			allBoards.put(getHashString(), allBoards.get(getHashString())+1);
		} else {
			allBoards.put(getHashString(), 1);
		}
	}


}

