package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            NumberBaseball game = new NumberBaseball();

            game.startGame();

            if (!game.wantRestart()) {
                break;
            }
        }
    }
}
