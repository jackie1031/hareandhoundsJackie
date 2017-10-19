package com.oose2017.tlin44.hareandhounds;

/**
 * a piece object will contain all attribute for a piece
 * @author Tianyi Lin
 *
 */
public class Piece {

    private String gameId;
    private String playerId;
    private String pieceType;
    private int x;
    private int y;

	/**
	 * Constructor
	 * @param gameId game id
	 * @param playerId player id
	 * @param pieceType   hare or hound
	 * @param x	  x-coordinate
	 * @param y   x-coordinate
	 */
	public Piece(String gameId, String playerId, String pieceType, int x, int y) {
		this.gameId = gameId;
		this.playerId = playerId;
		this.pieceType = pieceType;
		this.x = x;
		this.y = y;
	}

	private int fromX, fromY, toX, toY;

//	/**
//	 * the constructor
//	 * @param gameId game id
//	 * @param playerId player id
//	 * @param fromX the x-coordinate of start point
//	 * @param fromY the y-coordinate of start point
//	 * @param toX the x-coordinate of end point
//	 * @param toY the y-coordinate of end point
//	 */
//	public PieceJson(String gameId, String playerId, int fromX, int fromY,
//					 int toX, int toY) {
//
//		this.gameId = gameId;
//		this.playerId = playerId;
//		this.fromX = fromX;
//		this.fromY = fromY;
//		this.toX = toX;
//		this.toY = toY;
//	}



	/**
	 * get the x-coordinate of start point
	 * @return x-coordinate of start point
	 */
	public int getFromX() {
		return fromX;
	}

	/**
	 * get the y-coordinate of the start point
	 * @return y-coordinate of the start point
	 */
	public int getFromY() {
		return fromY;
	}

	/**
	 * get the x-coordinate of the end point
	 * @return  x-coordinate of the end point
	 */
	public int getToX() {
		return toX;
	}

	/**
	 * get the y-coordinate of the end point
	 * @return y-coordinate of the end point
	 */
	public int getToY() {
		return toY;
	}

//	@Override
//	public String toString() {
//		return "Piece {" +
//				"gameId='" + gameId + '\'' +
//				", playerId='" + playerId + '\'' +
//				", fromX='" + fromX + '\'' +
//				", fromY='" + fromY + '\'' +
//				", toX='" + toX + '\'' +
//				", toY='" + toY + '\'' +
//				'}';
//	}



//    /**
//     * get game id
//     * @return game id
//     */
//	public String getGameId() {
//		return gameId;
//	}
//
//	/**
//	 * set game id
//	 * @param gameId game id to set
//	 */
//	public void setGameId(String gameId) {
//		this.gameId = gameId;
//	}
	
	/**
	 * get player id 
	 * @return player id 
	 */
	public String getPlayerId() {
		return playerId;
	}
//
//	/**
//	 * set the player id
//	 * @param playerId player id
//	 */
//	public void setPlayerId(String playerId) {
//		this.playerId = playerId;
//	}

	/**
	 * get piece type
	 * @return piece type hare or hound
	 */
	public String getPieceType() {
		return pieceType;
	}

//	/**
//	 * set the piece type
//	 * @param pieceType piece type
//	 */
//	public void setPieceType(String pieceType) {
//		this.pieceType = pieceType;
//	}
//
//	/**
//	 * get this piece's x-coordinate
//	 * @return piece's x-coordinate
//	 */
//	public int getX() {
//		return x;
//	}
//
//	/**
//	 * set this piece's x-coordinate
//	 * @param x x-coordiante
//	 */
//	public void setX(int x) {
//		this.x = x;
//	}
//
//	/**
//	 * get this piece's y-coordinate
//	 * @return piece's y-coordinate
//	 */
//	public int getY() {
//		return y;
//	}
//
//	/**
//	 * set the piece's y-coordinate
//	 */
//	public void setY(int y) {
//		this.y = y;
//	}
    
    @Override
    public String toString() {
        return "Piece {" +
                "gameId='" + gameId + '\'' +
                ", playerId='" + playerId + '\'' +
                ", pieceType='" + pieceType + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
