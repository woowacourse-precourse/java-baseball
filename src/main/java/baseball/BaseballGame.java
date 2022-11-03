package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static constant.BaseballConstant.*;

public class BaseballGame {
    private static final List<Integer> computerNumbers = new ArrayList<>();
    private static String userNumber;

    public static void start() {
        makeRandomNumber();
        printMessage(START_MESSAGE + ENTER);
        getUserNumber();
    }

    private static void makeRandomNumber() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void getUserNumber() {
        printMessage(INPUT_MESSAGE);
        userNumber = Console.readLine();
    }
}
