package baseball;

import java.util.List;

import static baseball.ComputerNumber.createComputerNumber;
import static baseball.UserNumber.checkInputUserNumber;

public class BaseballGame {

    public static void playBaseballGame(){
        List<Integer> computerNumbers = createComputerNumber();
        while (true) {
            List<Integer> userNumbers = checkInputUserNumber();
        }
    }

}
