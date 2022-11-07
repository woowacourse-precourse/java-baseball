package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.stream.IntStream;

public class GameProcessor {

    private int strikeCount;
    private int ballCount;
    private final Computer computer;
    private final User user;

    public GameProcessor() {
        computer = new Computer();
        user = new User();
    }

    public void startGame() {
        OutputView.printStartMessage();
        computer.generateNumber();
    }

    public void playGame() {
        do {
            user.selectUserNumber(InputView.selectUserNumberInput());
        } while (isThreeStrike(computer.getComputerNumbers(), user.getUserInputNumbers()));
    }

    public boolean endOrRestartGame() {
        OutputView.printVictoryMessage();
        return InputView.selectEndOrRestartInput();
    }

    public boolean isThreeStrike(List<Integer> computerNumbers, List<Integer> userInputNumbers) {
        getStrikeCount(computerNumbers, userInputNumbers);
        getBallCount(computerNumbers, userInputNumbers);

        OutputView.printGameResult(strikeCount, ballCount);
        return isGameOver();
    }

    private boolean isGameOver() {
        return strikeCount != 3;
    }

    private int getStrikeCount(List<Integer> computerNumbers, List<Integer> userInputNumbers) {
        return strikeCount = (int) IntStream.range(0, 3)
                .filter(i -> computerNumbers.get(i) == userInputNumbers.get(i))
                .count();
    }

    private int getBallCount(List<Integer> computerNumbers, List<Integer> userInputNumbers) {
        return ballCount = (int) IntStream.range(0, 3)
                .filter(i -> computerNumbers.get(i) != userInputNumbers.get(i)
                        && computerNumbers.contains(userInputNumbers.get(i)))
                .count();
    }
}
