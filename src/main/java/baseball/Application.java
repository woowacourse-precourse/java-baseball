package baseball;

public class Application {
    private static final int NUMBER_LENGTH = 3;
    public static void main(String[] args) {
        Game.runGame();
    }

    public static int NUMBER_LENGTH() {
        return NUMBER_LENGTH;
    }
}