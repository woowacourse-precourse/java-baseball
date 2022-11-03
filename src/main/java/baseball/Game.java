package baseball;

public class Game {
    public static GameService gameService = new GameService();
    public void run() throws IllegalArgumentException{
        try {
            setGame();
            startGame();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            return;
        }

        resultGame();
        exitGame();
    }

    public void setGame()throws IllegalArgumentException{
        gameService.setGame();
    }
    public void startGame() throws IllegalArgumentException{
        gameService.startGame();
    }
    public void resultGame(){

    }
    public void exitGame(){

    }
}
