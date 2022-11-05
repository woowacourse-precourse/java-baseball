package baseball.controller;

import baseball.service.GameService;
import baseball.service.GameStatusService;
import baseball.view.GameStatusView;
import baseball.view.PlayerView;
import baseball.view.ScoreResultView;

public class GameController {
    GameService gameService;
    GameStatusService gameStatusService;
    PlayerView playerView;
    ScoreResultView scoreResultView;
    GameStatusView gameStatusView;

    public GameController(){
        gameService = new GameService();
        gameStatusService = new GameStatusService();
        playerView = new PlayerView();
        scoreResultView = new ScoreResultView();
        gameStatusView = new GameStatusView();
    }

    private void initializeGame(){

    }

    private void generateComputer(){
        gameService.setComputer();
    }

    private void generateGameStatus(){

    }

    private void startGame(){

    }

    private void clearScore(){

    }

    private void getPlayerNumbers(){

    }

    private void matchGame(){

    }

    private void showPlayersScore(){

    }

    private boolean isThreeStrike(){
        return true;
    }

    private void whatToDoNext(){

    }

    private String getPlayersOpinion(){
        return "";
    }

    private void setGameStatus(String opinion){

    }
}
