package baseball.domain.baseball;

import baseball.domain.baseball.status.BaseballGameStatus;
import baseball.domain.number.BaseballNumber;
import baseball.domain.referee.Referee;
import baseball.domain.score.Score;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballContextFake implements BaseballContext {
    private Referee referee;
    private List<BaseballNumber> original;
    private List<BaseballNumber> target;
    private BaseballGameStatus gameStatus;
    private String input;

    public BaseballContextFake() {

    }

    public BaseballContextFake(BaseballGameStatus status, List<Integer> number1, List<Integer> number2) {
        this.referee = new Referee();
        this.gameStatus = status;
        this.original = number1.stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());

        this.target = number2.stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
    }

    public BaseballContextFake(BaseballGameStatus status, String input) {
        this.input = input;
        this.gameStatus = status;
    }

    @Override
    public String input() {
        return input;
    }

    @Override
    public void initializeComputerNumber() {
        return;
    }

    @Override
    public void initializeParticipantNumber(String input) {
        return;
    }

    @Override
    public Score ruled() {
        return referee.ruled(original, target);
    }

    @Override
    public boolean runAble() {
        return this.gameStatus.runAble();
    }

    @Override
    public void next() {
        this.gameStatus = this.gameStatus.next(this);
    }

    @Override
    public void println(final String message) {
        System.out.println(message);
    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }
}
