package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class GameHandler {
    public static List<Integer> computerNumber;
    public static List<Integer> inputNumber;
    public static List<Integer> compareResult;

    public void init() {
        computerNumber = new ArrayList<>(3);
        inputNumber = new ArrayList<>(3);
        compareResult = new ArrayList<>(2);
    }

    public void inputHandler() {
        String input = Console.readLine();
        // validation check
        for(char c : input.toCharArray()) {
            inputNumber.add(c - '0');
        }
    }

    public void compareNumber() {
        int strike = 0, ball = 0, number;
        for(int i = 0; i < 3; i++) {
            number = inputNumber.get(i);
            if(number == computerNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(number)) {
                ball++;
            }
        }
        compareResult.add(strike);
        compareResult.add(ball);
    }
}
