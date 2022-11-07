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

        // 1 또는 2만 입력하고 있는지 확인

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
