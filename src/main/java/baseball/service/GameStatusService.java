package baseball.service;

public class GameStatusService {

    private static final String END_GAME = "2";

    private boolean gameStatus;

    public GameStatusService(){
        gameStatus = true;
    }

    public void setGameStatus(String opinion){
        if(isEndOfGame(opinion)) stopGame();
    }

    private boolean isEndOfGame(String opinion){
        return opinion.equals(END_GAME);
    }

    private void stopGame(){
        gameStatus = false;
    }

    public boolean getGameStatus(){
        return gameStatus;
    }
}
