package baseball.core;

import baseball.console.GameConsole;
import baseball.core.dto.BallStrikeDto;
import baseball.core.opponent.RandomNumberGenerator;

import java.util.List;

public class BaseballGameCore {

    private final User user;
    private ComputerOpponent opponent;
    private final GameConsole console;

    public BaseballGameCore(GameConsole console) {
        this.user = new User();
        this.console = console;
    }

    public void playBaseballGame() {
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
}
