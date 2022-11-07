package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = getRandomNumberList();
        String userInput = getUserInput();
        List<Integer> userAnswer = convertStringToIntegerList(userInput);
    }

    private static List<Integer> getRandomNumberList() {
        List computer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return computer;
    }

    private static String getUserInput() {
        String userInput = Console.readLine();
        return userInput;
    }

    private static List<Integer> convertStringToIntegerList(String userInput) {
        List<String> userInputStringList = Arrays.asList(userInput.split(""));
        List<Integer> userAnswer = new ArrayList<>();

        for (String str : userInputStringList) {
            int converted = Integer.parseInt(str);
            userAnswer.add(converted);
        }

        return userAnswer;
    }

}
