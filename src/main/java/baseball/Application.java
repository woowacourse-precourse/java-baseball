package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Application {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTING = "낫싱";
    private static final String RESTART = "1";
    private static final String EXIT = "2";
    private static final int REQUIRED_STRIKE_COUNT = 3;

    private final Map<String, Integer> result = new HashMap<>();

    private boolean gameExit = false;
    private boolean gameOver = false;

    public static void main(String[] args) {
        Application application = new Application();
        GameTextPrinter.printGameStartText();
        application.startGame();
    }

    private void startGame() {
        Computer computer = new Computer();
        User user = new User();

        while (!gameExit) {
            playGame(computer, user);
            checkUserWantsToRestartGame(computer);
        }
    }

    private void playGame(Computer computer, User user) {
        computer.generateRandomNumber();
        while (!gameOver) {
            GameTextPrinter.printUserInputText();
            user.inputNumber();
            compareTwoNumbers(computer.getNumber(), user.getNumber());
            clearUserNumberAndResult(user);
        }
        GameTextPrinter.printGameOverText(REQUIRED_STRIKE_COUNT);
    }

    private void checkUserWantsToRestartGame(Computer computer) {
        switch (Console.readLine()) {
            case RESTART:
                computer.clearComputerNumber();
                gameOver = false;
                break;
            case EXIT:
                gameExit = true;
                break;
            default:
                InputValidator.executeUserAnswerException();
                break;
        }
    }

    private void clearUserNumberAndResult(User user) {
        user.clearNumber();
        result.clear();
    }

    private void compareTwoNumbers(List<Integer> computerNumber, List<Integer> userNumber) {
        int sameDigitCount = Math.toIntExact(userNumber.stream().filter(computerNumber::contains).count());
        int strikeCount = getStrikeCount(computerNumber, userNumber);
        int ballCount = sameDigitCount - strikeCount;

        if (isNothing(sameDigitCount)) {
            GameTextPrinter.printNoting(NOTING);
        }

        if (!isNothing(sameDigitCount)) {
            setResult(strikeCount, ballCount);
            GameTextPrinter.printCompareResult(result);
        }
        checkGameOver(strikeCount);
    }

    private void setResult(int strikeCount, int ballCount) {
        result.put(BALL, ballCount);
        result.put(STRIKE, strikeCount);
    }

    private boolean isNothing(int sameDigitCount) {
        return Objects.equals(sameDigitCount, 0);
    }

    private int getStrikeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikeCount = 0;
        for (int index = 0; index < computerNumber.size(); index++) {
            if (Objects.equals(computerNumber.get(index), userNumber.get(index))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private void checkGameOver(int strikeCount) {
        if (isGameOver(strikeCount)) {
            gameOver = true;
        }
    }

    private boolean isGameOver(int strikeCount) {
        return Objects.equals(strikeCount, REQUIRED_STRIKE_COUNT);
    }
}
