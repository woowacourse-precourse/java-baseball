package baseball;

public class Application {
    public static void main(String[] args) {
        Message.gameStart();
        GameSystem gameSystem = new GameSystem();
        gameSystem.startGame();
    }
}