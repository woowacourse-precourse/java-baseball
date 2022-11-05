package baseball.controller;

import baseball.service.GameService;
import baseball.service.GameStatusService;
import baseball.view.GameStatusView;
import baseball.view.PlayerView;
import baseball.view.ScoreResultView;

public class GameController {
    private static final int THREE_STRIKE = 3;
    GameService gameService;
    GameStatusService gameStatusService;
    PlayerView playerView;
    ScoreResultView scoreResultView;
    GameStatusView gameStatusView;

    public GameController(){
        gameService = new GameService();
        playerView = new PlayerView();
        scoreResultView = new ScoreResultView();
        gameStatusView = new GameStatusView();
        gameStatusService = new GameStatusService();
    }

    public void runGame(){
        generateGameStatus();
        while(gameStatusService.getGameStatus()){
            generateComputer();
            startGame();
            whatToDoNext();
        }
    }

    private void generateComputer(){
        gameService.setComputer();
    }

    private void generateGameStatus(){
        gameStatusService = new GameStatusService();
    }

    private void startGame(){
        while(!isThreeStrike()){
            clearScore();
            getPlayerNumbers();
            matchGame();
            showPlayersScore();
        }
    }

    private void clearScore(){
        gameService.initializeScore();
    }

    private void getPlayerNumbers(){
        gameService.setPlayer(playerView.getPlayerOpinion());
    }

    private void matchGame(){
        gameService.checkComputerWithPlayerNumber();
    }

    private void showPlayersScore(){
        scoreResultView.setBallCount(gameService.getBallCount());
        scoreResultView.setStrikeCount(gameService.getStrikeCount());
        scoreResultView.printScore();
    }

    private boolean isThreeStrike(){
        return gameService.getStrikeCount() == THREE_STRIKE;
    }

    private void whatToDoNext(){
        setGameStatus(getPlayersOpinion());
    }

    private String getPlayersOpinion(){
        return gameStatusView.getOpinion();
    }

    private void setGameStatus(String opinion){
        gameStatusService.setGameStatus(opinion);
    }
}
