package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.constant.GameConstant.*;
import static baseball.constant.GameMessage.*;
import static baseball.game.CompareNumbers.*;
import static baseball.number.ComputerNumber.createComputerNumber;
import static baseball.exception.RestartNumberValidator.checkValidationRestartNumber;
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
