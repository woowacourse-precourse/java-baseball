package baseball;

import java.util.List;

import static baseball.ComputerNumber.createComputerNumber;
import static baseball.UserNumber.checkInputUserNumber;

public class BaseballGame {

    public static void startBaseballGame() {
        List<Integer> computerNumbers = createComputerNumber();
        List<Integer> userNumbers = checkInputUserNumber();
    }

}
