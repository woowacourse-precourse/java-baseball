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
        initializeGame();
        while(wantToPlay()){
            playGame();
        }
        finishGame();
    }

    private void finishGame(){
        gameStatusView.printTheEnd();
    }

    private void playGame(){
        setGame();
        startGame();
        whatToDoNext();
    }

    private void setGame(){
        gameService.setComputer();
        clearScore();
    }

    private void initializeGame(){
        gameStatusService = new GameStatusService();
    }

    private void startGame(){
        while(!isThreeStrike()) {
            clearScore();
            putPlayerInService(getPlayerNumbers());
            matchGame();
            showPlayersScore();
        }
    }

    private void putPlayerInService(String playerNumbers){
        gameService.setPlayer(playerNumbers);
    }

    private void clearScore(){
        gameService.initializeScore();
    }

    private String getPlayerNumbers(){
        return playerView.getPlayerOpinion();
    }

    private void matchGame(){
        gameService.checkComputerWithPlayerNumber();
    }

    private void showPlayersScore(){
        giveScoreToView();
        printScore();
    }

    private void giveScoreToView(){
        scoreResultView.setBallCount(gameService.getBallCount());
        scoreResultView.setStrikeCount(gameService.getStrikeCount());
    }

    private void printScore(){
        scoreResultView.printScore();
    }

    private boolean isThreeStrike(){
        return gameService.getStrikeCount() == THREE_STRIKE;
    }

    private void whatToDoNext(){
        setGameStatus(getPlayersOpinion());
    }

    private String getPlayersOpinion(){
        return gameStatusView.inquireOpinion();
    }

    private void setGameStatus(String opinion){
        gameStatusService.setGameStatus(opinion);
    }

    private boolean wantToPlay(){
        return gameStatusService.getGameStatus();
    }
}
