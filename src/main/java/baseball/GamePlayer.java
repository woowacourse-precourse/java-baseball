package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GamePlayer {
    public List<Integer> getThreeNumber() {
        String threeNumber = Console.readLine();

        ExceptionController.handleInvalidThreeRandomNumber(threeNumber);

        return makeListOfThreeNumbers(threeNumber);
    }

    public int respondToFinishRequest() {
        String responseNumber = Console.readLine();

        ExceptionController.handleInvalidFinishCode(responseNumber);

        return responseNumber.charAt(0) - '0';
    }

    private List<Integer> makeListOfThreeNumbers(String threeNumber) {
        List<Integer> threeNumbers = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            int number = threeNumber.charAt(i) - '0';
            threeNumbers.add(number);
        }

        return threeNumbers;
    }
}
