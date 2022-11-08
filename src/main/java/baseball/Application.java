package baseball;

public class Application {
    public static void main(String[] args) {
        GameHandler gameHandler = new GameHandler();
        gameHandler.init();
        while(true) {
            if(gameHandler.isGameEnd && gameHandler.askEnd()) {
                break;
            }
            gameHandler.inputHandler();
            gameHandler.compareNumber();
            gameHandler.getResult();
        }
    }
}
