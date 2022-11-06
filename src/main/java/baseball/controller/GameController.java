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
            setGame();
            startGame();
            whatToDoNext();
        }
        finishGame();
    }

    private void finishGame(){
        gameStatusView.printTheEnd();
    }

    void setGame(){
        gameService.setComputer();
        clearScore();
    }

    void initializeGame(){
        gameStatusService = new GameStatusService();
    }

    void startGame(){
        while(!isThreeStrike()) {
            clearScore();
            putPlayerInService(getPlayerNumbers());
            matchGame();
            showPlayersScore();
        }
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
        setGameStatus(getPlayersOpinion());
    }

    String getPlayersOpinion(){
        return gameStatusView.inquireOpinion();
    }

    void setGameStatus(String opinion){
        gameStatusService.setGameStatus(opinion);
    }

    boolean wantToPlay(){
        return gameStatusService.getGameStatus();
    }
}
