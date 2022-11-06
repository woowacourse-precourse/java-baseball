package baseball.controller;

import baseball.service.GameService;
import baseball.service.GameStatusService;
import baseball.view.GameStatusView;
import baseball.view.PlayerView;
import baseball.view.ScoreResultView;

public class GameController {

    GameService gameService = new GameService();
    GameStatusService gameStatusService;

    public GameController(){

    }

    public void runGame(){
    }

    void setGame(){
    }

    void initializeGame(){
        gameStatusService = new GameStatusService();
    }

    void startGame(){
    }

    void putPlayerInService(String playerNumbers){

    }

    void clearScore(){
    }

    String getPlayerNumbers(){
        return "";
    }

    void matchGame(){
    }

    void showPlayersScore(){
    }

    boolean isThreeStrike(){
        return false;
    }

    void whatToDoNext(){
    }

    String getPlayersOpinion(){
        return "";
    }

    void setGameStatus(String opinion){

    }
}
