package baseball;

public class Application {
    public static boolean exitSign;

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        while (gameManager.startGame()) {}
    }
}
