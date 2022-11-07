package baseball.mainframe;

import baseball.view.GameOutput;
import baseball.view.GameInput;

public class Game {

    private User user;
    private Computer computer;
    private Score score;
    private final String RESTART_VALUE = "1";

    public Game() {
        user = new User();
        computer = new Computer();
        score = new Score();
    }

    public void start() {
        computer.generateRandomNumber();
        do {
            GameInput.getUserInput();
            score.countBallAndStrike(user.getUserInputValue(), computer.getRandomNumber());
            score.printScore();
        } while (!score.isCorrectAnswer());
        GameOutput.printEndGame();
        GameInput.getUserRestartInput();
        if (user.getUserRestartInputValue().equals(RESTART_VALUE)) {
            start();
        }
    }
}
