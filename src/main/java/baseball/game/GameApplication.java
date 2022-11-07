package baseball.game;

import baseball.game.domain.GameResult;
import baseball.game.domain.GameStatus;
import baseball.game.utils.GameUtil;
import baseball.game.view.GameView;
import baseball.input.utils.NumberUtil;
import baseball.input.validation.UserNumberValidation;
import baseball.input.view.InputView;
import java.util.List;
import java.util.Objects;

public class GameApplication {

    public static void startGame() {
        List<Integer> computerNumber = GameUtil.getComputerNumber();
        playGame(computerNumber);
    }

    public static void playGame(List<Integer> computerNumber) {
        GameStatus gameStatus = GameStatus.START;
        while (gameStatus == GameStatus.START) {
            String inputNumber = InputView.inputNumber();

            validateInput(inputNumber);

            List<Integer> userNumber = NumberUtil.getDigitNumberList(inputNumber);

            GameResult gameResult = getResult(userNumber, computerNumber);
            System.out.println(gameResult);

            if (gameResult.isGameOver()) {
                GameView.printGameOverMessage();
                gameStatus = askGameStatus();
            }

            if (gameStatus == GameStatus.RESTART) {
                startGame();
            }

            if (gameStatus == GameStatus.EXIT) {
                break;
            }

        }

    }

    public static GameResult getResult(List<Integer> userNumber, List<Integer> computerNumber) {
        GameResult gameResult = new GameResult();
        for (int userIndex = 0; userIndex < 3; userIndex++) {
            for (int computerIndex = 0; computerIndex < 3; computerIndex++) {
                compareUserNumberWithComputerNumber(userNumber.get(userIndex),
                        computerNumber.get(computerIndex), userIndex, computerIndex, gameResult);
            }
        }
        gameResult.setNothing();
        return gameResult;
    }

    public static void compareUserNumberWithComputerNumber(Integer userDigitNumber,
            Integer computerDigitNumber, int userIndex, int computerIndex, GameResult gameResult) {
        if (Objects.equals(userDigitNumber, computerDigitNumber)) {
            if (Objects.equals(userIndex, computerIndex)) {
                gameResult.plusStrike();
            } else {
                gameResult.plusBall();
            }
        }
    }

    public static void validateInput(String inputNumber) {
        if (!UserNumberValidation.isValidNumberLength(inputNumber)) {
            throw new IllegalArgumentException();
        }

        if (!UserNumberValidation.hasEachDifferentNumbers(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public static GameStatus askGameStatus() {
        int inputNumber= Integer.parseInt(InputView.inputNumber());

        if (inputNumber == GameStatus.RESTART.ordinal()) {
            return GameStatus.RESTART;
        }

        if (inputNumber == GameStatus.EXIT.ordinal()){
            return GameStatus.EXIT;
        }

        throw new IllegalArgumentException();
    }

}
