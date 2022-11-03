package baseball.game;

import baseball.input.utils.NumberUtil;
import baseball.input.validation.UserNumberValidation;
import baseball.input.view.InputView;
import java.util.List;

public class GameApplication {

    public static void startGame() {
        playGame();
    }

    public static void playGame() {
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
