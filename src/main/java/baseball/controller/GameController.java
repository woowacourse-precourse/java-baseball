package baseball.controller;

import baseball.service.GameService;
import baseball.service.GameStatusService;
import baseball.view.GameStatusView;
import baseball.view.PlayerView;
import baseball.view.ScoreResultView;

public class GameController {

    GameService gameService = new GameService();
    GameStatusService gameStatusService;
    PlayerView playerView = new PlayerView();

    public GameController(){}

    public void runGame(){
    }

    void setGame(){
        gameService.setComputer();
    }

    void initializeGame(){
        gameStatusService = new GameStatusService();
    }

    void startGame(){

    }

    void putPlayerInService(String playerNumbers){
        gameService.setPlayer(playerNumbers);
    }

    void clearScore(){
        gameService.initializeScore();
    }

    String getPlayerNumbers(){
        return playerView.getPlayerOpinion();
    }

    void matchGame(){
        gameService.checkComputerWithPlayerNumber();
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
