package baseball;

import baseball.console.ConsoleOutput;
import baseball.core.StatusCode;
import baseball.core.Computer;
import baseball.core.Player;
import baseball.core.BallStrike;
import baseball.core.RandomNumberGenerator;

import java.util.List;

public class BaseballGame {

    private final ConsoleOutput console;
    private final Player player;
    private final Computer computer;

    public BaseballGame() {
        this.computer = new Computer(RandomNumberGenerator.generate());
        this.player = new Player();
        this.console = new ConsoleOutput();
    }

    public void play() throws IllegalArgumentException {
        console.printStartMessage();
        playBaseball();
        restartOrExitGame();
    }

    private void playBaseball() {
        BallStrike answer;
        do {
            inputThreeNumbers();
            answer = processAnswering();
        } while (isWrongAnswer(answer));
        processFinishGame();
    }

    private void inputThreeNumbers() {
        console.printNumberInputMessage();
        player.inputThreeNumbers();
    }

    private void restartOrExitGame() {
        console.printRestartOrExitMessage();
        StatusCode code = player.inputStatusCode();
        if (isStartCode(code)) {
            new BaseballGame().play();
        }
    }

    private BallStrike processAnswering() {
        List<Integer> threeNumbers = player.sayThreeNumbers();
        BallStrike answer = computer.answer(threeNumbers);
        console.printResultMessage(answer);
        return answer;
    }

    private boolean isWrongAnswer(BallStrike answer) {
        return answer.getStrikeCount() != 3;
    }

    private void processFinishGame() {
        console.printFinishMessage();
    }

    private boolean isStartCode(StatusCode code) {
        return code.equals(StatusCode.START_CODE);
    }
}
