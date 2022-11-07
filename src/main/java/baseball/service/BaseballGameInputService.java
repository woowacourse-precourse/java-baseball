package baseball.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameInputService {

    static ValidateNumberService validateNumberService = new ValidateNumberService();

    public static List<Integer> getUserInput() {
        String userStringInput = Console.readLine();
        List<Integer> userIntegerListInput = new ArrayList<>();

        validateNumberService.validateUserInput(userStringInput);
        stringToIntegerList(userStringInput, userIntegerListInput);

        return userIntegerListInput;
    }

    public static Integer getRestartInput() {
        String userStringRestartInput = Console.readLine();

        validateNumberService.validateRestartInput(userStringRestartInput);

        return Integer.parseInt(userStringRestartInput);
    }

    private static void stringToIntegerList(String userStringInput, List<Integer> userIntegerListInput) {
        for (int i = 0; i < userStringInput.length(); i++) {
            userIntegerListInput.add(Integer.parseInt(String.valueOf(userStringInput.charAt(i))));
        }
    }

}
