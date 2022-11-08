package baseball.game;

import baseball.number.ComputerNumber;
import baseball.number.UserNumber;
import baseball.validator.RestartNumberValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.constant.GameConstant.BALL_LEN;
import static baseball.constant.GameConstant.RESTART;
import static baseball.constant.GameMessage.END_MESSAGE;
import static baseball.constant.GameMessage.RESTART_MESSAGE;

public class BaseballGame {

    public static List<Integer> computerNumbers;
    public static List<Integer> userNumbers;
    private CompareNumbers compareNumbers = new CompareNumbers();
    private ComputerNumber computerNumber = new ComputerNumber();
    private UserNumber userNumber = new UserNumber();
    private RestartNumberValidator restartNumberValidator = new RestartNumberValidator();

    public void playBaseballGame(){
        computerNumbers = computerNumber.createComputerNumber();
        compareNumbers.resetStrikeBall();
        while (compareNumbers.strike!=BALL_LEN) {
            userNumbers = userNumber.checkInputUserNumber();
            compareNumbers.resetStrikeBall();
            compareNumbers.compareNumber();
            compareNumbers.userNumberResult();
        }
        System.out.println(END_MESSAGE);
        askRestartGame();
    }

    private void askRestartGame(){
        System.out.println(RESTART_MESSAGE);
        String restartNumber = Console.readLine();
        restartNumberValidator.checkValidationRestartNumber(restartNumber);
        restartGame(restartNumber);
    }

    private void restartGame(String restartNumber){
        if (restartNumber.equals(RESTART)) playBaseballGame();
    }

}
