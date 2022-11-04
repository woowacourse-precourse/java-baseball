package baseball;

public class Application {
    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine(new BaseballGame());
        gameMachine.start();
    }
}
