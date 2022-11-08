package baseball;

public class Application {
    public static void main(String[] args) {
        GameHandler gameHandler = new GameHandler();
        gameHandler.init();
        gameHandler.start();
        while(true) {
            if(gameHandler.isGameEnd && gameHandler.askEnd()) {
                break;
            } else if(gameHandler.isGameEnd) {
                gameHandler.start();
            }
            gameHandler.inputHandler();
            gameHandler.compareNumber();
            gameHandler.getResult();
        }
    }
}
