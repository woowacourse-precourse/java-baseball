package baseball;


import baseball.system.GameSystem;

public class Application {
    public static void main(String[] args) {
        System.err.close();
        System.setErr(System.out);
        // TODO: 프로그램 구현
        GameSystem gameSystem = new GameSystem();
        gameSystem.runGame();
    }
}
