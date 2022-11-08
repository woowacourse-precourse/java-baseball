package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class GameHandler {
    public static List<Integer> computerNumber;
    public static List<Integer> inputNumber;
    public static List<Integer> compareResult;

    public void init() {
        computerNumber = new ArrayList<>();
        inputNumber = new ArrayList<>();
        compareResult = new ArrayList<>();
    }

    public void inputHandler() {
        String input = Console.readLine();
        // validation check
        for(char c : input.toCharArray()) {
            inputNumber.add(c - '0');
        }
    }
}
