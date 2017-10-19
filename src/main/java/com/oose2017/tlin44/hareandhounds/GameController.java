package com.oose2017.tlin44.hareandhounds;

//-------------------------------------------------------------------------------------------------------------//
// Code based on a tutorial by Shekhar Gulati of SparkJava at
// https://blog.openshift.com/developing-single-page-web-applications-using-java-8-spark-mongodb-and-angularjs/
//-------------------------------------------------------------------------------------------------------------//


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static spark.Spark.*;

/**
 * @author Tianyi Lin
 *
 */
public class GameController {

	private static final String API__CONTEXT = "/hareandhounds/api";

	private final GameService gameService;
    private final Logger logger = LoggerFactory.getLogger(GameController.class);
    
    /**
     * Initialize
     * @param gameService generated at the main method
     */
    public GameController(GameService gameService) {
        this.gameService = gameService;
        setupEndpoints();
    }

    /**
     * the interface communicating with the front end javascript
     */
    private void setupEndpoints() {

		//Get method to start a new game.
		post(API__CONTEXT+"/games", "application/json", (request, response) -> {
			try {
				response.status(201);
				return gameService.createNewGame(request.body());
//			} catch (Exception e) {
//				logger.error("Unable to create a new game.");
//				return Collections.EMPTY_MAP;
			}catch (GameService.GameServiceInvalidPieceType ex) {
				response.status(400);
				return Collections.EMPTY_MAP;
		}
		}, new JsonTransformer());

		//Get method to describe game board
        get(API__CONTEXT + "/games"+"/:id" + "/board", "application/json", (request, response) -> {

			try {
				response.status(200);
				return gameService.getBoard(request.params(":id"));
			} catch (GameService.GameServiceGameIdException ex) {
				response.status(404);
				return Collections.EMPTY_MAP;
			}
        }, new JsonTransformer());

		//Get method to describe game state
		get(API__CONTEXT+ "/games/:id" + "/state", "application/json", (request, response) -> {
			try {
				response.status(200);
				return gameService.getState(request.params(":id"));
			} catch (GameService.GameServiceGameIdException ex) {
				response.status(404);
				return Collections.EMPTY_MAP;
			}
        }, new JsonTransformer());



		//Put method to join a game
        put(API__CONTEXT+"/games/:id", "application/json", (request, response) -> {
            try {
				response.status(200);
				return gameService.joinGame(request.params(":id"));
			} catch (GameService.GameServiceGameIdException ex) {
				response.status(404);
			} catch (GameService.GameServiceAlreadyJoinException ex) {
				response.status(410);
			}
            return Collections.EMPTY_MAP;		     
        }, new JsonTransformer());


		//Post method to move the piece and play around
        post(API__CONTEXT+"/games/:id/turns", "application/json", (request, response) -> {
            try {
            	response.status(200);
				gameService.move(request.params(":id"), request.body());
				
			} catch (GameService.GameServiceGameIdException ex){
				response.status(404);
				return new ResponseContent(ex.getMessage());
			} catch (GameService.GameServiceIncorrectTure ex) {
				response.status(422);
				return new ResponseContent(ex.getMessage());
			} catch (GameService.GameServicePlayerIdException ex) {
				response.status(404);
				return new ResponseContent(ex.getMessage());
			} catch (GameService.GameServiceIllegalMove ex) {
				response.status(422);
				return new ResponseContent(ex.getMessage());
			}
            return Collections.EMPTY_MAP;
        }, new JsonTransformer());
    }
}
