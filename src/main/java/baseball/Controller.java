package baseball;

public class Controller {
    public static GameService gameService = new GameService();
    public void run() throws IllegalArgumentException{
            setGame();
            startGame();
            finishGame();
    }

    public void setGame()throws IllegalArgumentException{
        gameService.setGame();
    }
    public void startGame() throws IllegalArgumentException{
        gameService.startGame();
    }
    public void finishGame(){
        gameService.finishGame();
    }
}
