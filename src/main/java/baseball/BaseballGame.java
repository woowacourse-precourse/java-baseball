package baseball;

public class BaseballGame {
    private final OutputView outputView = new OutputView();
    public BaseballGame() {
    }

    public void gameStart() {
        while (true) {
            outputView.printGameStart();
            Computer computer = new Computer();
            game();
        }
    }

    public void game() {
        while (true) {
            User user = new User();
        }
    }
}
