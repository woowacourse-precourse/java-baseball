package baseball;

public class Application {

    private static final int STARTOFGAME = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.startGame(STARTOFGAME);
    }
}
