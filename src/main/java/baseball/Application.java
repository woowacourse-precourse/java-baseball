package baseball;


import baseball.system.GameSystem;

public class Application {
    public static void main(String[] args) {
        System.err.close();
        System.setErr(System.out);

        GameSystem gameSystem = new GameSystem();
        gameSystem.runGame();
    }
}
