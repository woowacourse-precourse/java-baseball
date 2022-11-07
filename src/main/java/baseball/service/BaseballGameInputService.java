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

        return null;
    }

    public static Integer getRestartInput() {

        return 0;
    }

}
