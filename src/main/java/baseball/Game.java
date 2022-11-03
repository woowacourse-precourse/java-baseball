package baseball;

import baseball.GameService;

public class Game {
    public void run(){
        setGame();
        startGame();
        resultGame();
        exitGame();
    }

    public void setGame(){
        GameService gameService = new GameService();
        gameService.setGame();
    }
    public void startGame(){

    }
    public void resultGame(){

    }
    public void exitGame(){

    }
}
