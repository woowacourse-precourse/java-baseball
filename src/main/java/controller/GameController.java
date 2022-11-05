package controller;

import decision.DecisionMaker;
import game.Game;

public class GameController {
    private Game game;
    private DecisionMaker decisionMaker;
    private int timesOfPlayGame = 0;

    public GameController(Game game, DecisionMaker decisionMaker) {
        this.game = game;
        this.decisionMaker = decisionMaker;
    }

    public GameController(){
        this.game = new Game();
        this.decisionMaker = new DecisionMaker();
    }

    public void playRecurringGame() {
        String decision = "Play";
        while (decision.equals("Play")) {
            playGame();
            decision = getUserDecision();
        }
    }

    public int getTimesOfPlayGame() {
        return timesOfPlayGame;
    }

    private void playGame() {
        game.play();
        timesOfPlayGame+=1;
    }

    private String getUserDecision() {
        return decisionMaker.getDecision();
    }



}
