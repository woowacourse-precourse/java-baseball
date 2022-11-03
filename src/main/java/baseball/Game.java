package baseball;

import baseball.GameService;

public class Game {
    public static GameService gameService = new GameService();
    public void run(){
        setGame();
        startGame();
        resultGame();
        exitGame();
    }

    public void setGame(){
        gameService.setGame();
    }
    public void startGame(){
        gameService.startGame();
    }
    public void resultGame(){

    }
    public void exitGame(){

    }
}
