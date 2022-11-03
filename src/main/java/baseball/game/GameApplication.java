package baseball.game;

import baseball.game.utils.GameUtil;
import baseball.input.utils.NumberUtil;
import baseball.input.validation.UserNumberValidation;
import baseball.input.view.InputView;
import java.util.List;

public class GameApplication {

    public static void startGame() {
        List<Integer> computerNumber = GameUtil.getComputerNumber();
        playGame(computerNumber);
    }

    public static void playGame(List<Integer> computerNumber) {
        String userNumber = InputView.inputNumber();
        if (!UserNumberValidation.isValidNumberLength(userNumber)) {
            throw new IllegalArgumentException();
        }

        List<String> userDigitNumberList = NumberUtil.getDigitNumberList(userNumber);

        if (UserNumberValidation.hasEachDifferentNumbers(userDigitNumberList)) {
            throw new IllegalArgumentException();
        }
    }



}
