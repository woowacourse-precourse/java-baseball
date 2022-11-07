package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean start = true;
        while (start) {
            Game game = new Game();
            start = game.gameStart();
        }
    }
}

