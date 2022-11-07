package baseball;

import baseball.console.GameConsole;
import baseball.core.StatusCode;
import baseball.core.ComputerOpponent;
import baseball.core.User;
import baseball.core.dto.BallStrikeDto;
import baseball.core.opponent.RandomNumberGenerator;

import java.util.List;

import static baseball.console.input.converter.RestartOrExitCodeConverter.START_CODE;

public class BaseballGame {

    private final GameConsole console;
    private final User user;
    private ComputerOpponent opponent;

    public BaseballGame() {
        this.user = new User();
        this.console = new GameConsole();
    }

    public void play() throws IllegalArgumentException {
        int statusCode;

        console.printStartMessage();
        do {
            playGameCycle();
            statusCode = restartOrExitProcess();
        } while (isStartCode(statusCode));
    }

    private void playGameCycle() {
        try {
            playBaseball();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void playBaseball() {
        initOpponent();
        BallStrikeDto answer;
        do {
            inputProcess();
            answer = answerProcess();
        } while (isWrongAnswer(answer));
        finishProcess();
    }

    private void initOpponent() {
        this.opponent = new ComputerOpponent(RandomNumberGenerator.generate());
    }

    private void inputProcess() {
        console.printNumberInputMessage();
        user.inputThreeNumbers(console);
    }

    private BallStrikeDto answerProcess() {
        List<Integer> threeNumbers = user.sayThreeNumbers();
        BallStrikeDto answer = opponent.answer(threeNumbers);
        console.printResultMessage(answer);
        return answer;
    }

    private boolean isWrongAnswer(BallStrikeDto answer) {
        return answer.getStrikeCount() != 3;
    }

    private void finishProcess() {
        console.printFinishMessage();
    }

    private boolean isStartCode(StatusCode code) {
        return code.equals(StatusCode.START_CODE);
        return console.inputCode();
    }

    private boolean isStartCode(int statusCode) {
        return statusCode == START_CODE;
    }
}
