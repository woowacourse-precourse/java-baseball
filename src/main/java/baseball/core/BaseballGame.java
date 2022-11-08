package baseball.core;

import baseball.console.ConsoleOutput;
import baseball.util.RandomNumberGenerator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.util.BaseballConst.STRIKE_OUT;

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
    }

    private void playBaseball() {
        BallStrike answer;

        do {
            console.printNumberInputMessage();
            player.inputThreeNumbers(Console.readLine());

            List<Integer> threeNumbers = player.sayThreeNumbers();
            answer = computer.answer(threeNumbers);
            console.printResultMessage(answer);

        } while (isWrongAnswer(answer));
        console.printFinishMessage();

        restartOrExitGame();
    }

    private void restartOrExitGame() {
        console.printRestartOrExitMessage();
        StatusCode code = player.inputStatusCode(Console.readLine());
        if (isStartCode(code)) {
            computer.setNewAnswer(RandomNumberGenerator.generate());
            playBaseball();
        }
    }

    private boolean isWrongAnswer(BallStrike answer) {
        return answer.getStrikeCount() != STRIKE_OUT;
    }

    private boolean isStartCode(StatusCode code) {
        return code.equals(StatusCode.START_CODE);
    }
}
