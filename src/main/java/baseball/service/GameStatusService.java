package baseball.service;

public class GameStatusService {

    private static final String END_GAME = "2";

    private boolean gameStatus;

    public GameStatusService(){
        gameStatus = true;
    }

    public boolean isEndOfGame(String opinion){
        return opinion.equals(END_GAME);
    }

    public void stopGame(){
        gameStatus = false;
    }

    public boolean getGameStatus(){
        return false;
    }
}
