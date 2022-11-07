package baseball.controller;

import baseball.decision.Decision;
import baseball.decision.DecisionMaker;
import baseball.game.Game;

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
        Decision decision = Decision.PLAY;
        game.printStartingMessage();
        while (decision.equals(Decision.PLAY)) {
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

    private Decision getUserDecision() {
        return decisionMaker.getDecision();
    }



}
