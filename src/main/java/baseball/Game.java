package baseball;

import baseball.GameService;

public class Game {
    public static GameService gameService = new GameService();
    public void run() throws IllegalArgumentException{
        try {
            setGame();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            return;
        }
        startGame();
        resultGame();
        exitGame();
    }

    public void setGame()throws IllegalArgumentException{
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
