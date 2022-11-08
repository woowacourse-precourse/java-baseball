package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.constant.GameConstant.BALL_LEN;
import static baseball.constant.GameConstant.RESTART;
import static baseball.constant.GameMessage.END_MESSAGE;
import static baseball.constant.GameMessage.RESTART_MESSAGE;
import static baseball.game.CompareNumbers.compareNumber;
import static baseball.game.CompareNumbers.resetStrikeBall;
import static baseball.game.CompareNumbers.strike;
import static baseball.game.CompareNumbers.userNumberResult;
import static baseball.number.ComputerNumber.createComputerNumber;
import static baseball.validator.RestartNumberValidator.checkValidationRestartNumber;
import static baseball.number.UserNumber.checkInputUserNumber;

public class BaseballGame {

    public static List<Integer> computerNumbers;
    public static List<Integer> userNumbers;

    public static void playBaseballGame(){
        computerNumbers = createComputerNumber();
        resetStrikeBall();
        while (strike!=BALL_LEN) {
            userNumbers = checkInputUserNumber();
            resetStrikeBall();
            compareNumber();
            userNumberResult();
        }
        System.out.println(END_MESSAGE);
        restartGame();
    }

    public static void restartGame(){
        System.out.println(RESTART_MESSAGE);
        String restartNumber = Console.readLine();
        checkValidationRestartNumber(restartNumber);
        if (restartNumber.equals(RESTART)) playBaseballGame();
    }
}
