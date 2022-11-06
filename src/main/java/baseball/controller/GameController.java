package baseball.controller;

import baseball.service.GameService;
import baseball.service.GameStatusService;
import baseball.view.GameStatusView;
import baseball.view.PlayerView;
import baseball.view.ScoreResultView;

public class GameController {

    private static final int THREE_STRIKE = 3;

    GameService gameService = new GameService();
    GameStatusService gameStatusService = new GameStatusService();
    PlayerView playerView = new PlayerView();
    ScoreResultView scoreResultView = new ScoreResultView();
    GameStatusView gameStatusView = new GameStatusView();

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
        giveScoreToView();
        printScore();
    }

    void giveScoreToView(){
        scoreResultView.setBallCount(gameService.getBallCount());
        scoreResultView.setStrikeCount(gameService.getStrikeCount());
    }

    void printScore(){
        scoreResultView.printScore();
    }

    boolean isThreeStrike(){
        return gameService.getStrikeCount() == THREE_STRIKE;
    }

    void whatToDoNext(){
    }

    String getPlayersOpinion(){
        return gameStatusView.inquireOpinion();
    }

    void setGameStatus(String opinion){
        gameStatusService.setGameStatus(opinion);
    }
}
