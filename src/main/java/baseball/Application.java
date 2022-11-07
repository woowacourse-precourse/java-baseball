package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = getRandomNumberList();
        String userInput = getUserInput();
    }

    private static List<Integer> getRandomNumberList() {
        List computer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return computer;
    }

    private static String getUserInput() {
        String userInput = Console.readLine();
        return userInput;
    }

}
