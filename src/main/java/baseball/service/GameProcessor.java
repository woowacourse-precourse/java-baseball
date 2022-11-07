package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.stream.IntStream;

public class GameProcessor {

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
        int strikeCount = countStrike(computerNumbers, userInputNumbers);
        int ballCount = countBall(computerNumbers, userInputNumbers);
        OutputView.printGameResult(strikeCount, ballCount);
        return isGameOver(strikeCount);
    }

    private boolean isGameOver(int strikeCount) {
        return strikeCount != 3;
    }

    private int countStrike(List<Integer> computerNumbers, List<Integer> userInputNumbers) {
        return (int) IntStream.range(0, 3)
                .filter(i -> computerNumbers.get(i) == userInputNumbers.get(i))
                .count();
    }

    private int countBall(List<Integer> computerNumbers, List<Integer> userInputNumbers) {
        return (int) IntStream.range(0, 3)
                .filter(i -> computerNumbers.get(i) != userInputNumbers.get(i)
                        && computerNumbers.contains(userInputNumbers.get(i)))
                .count();
    }
}
