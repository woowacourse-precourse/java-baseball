package baseball.userInterface;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

import static baseball.userInterface.InputValidator.*;
import static baseball.userInterface.View.*;

public class Input {
    public static List<Integer> getUserInput() {
        ViewInputNumber();
        String userInput = Console.readLine();
        try {
            validateUserInput(userInput);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            System.exit(0);
        }
        return parseStringToList(userInput);
    }

    public static int getIsPlayAgainCode() {
        viewAskPlayAgainMessage();
        String isPlayAgainCode = Console.readLine();
        try {
            validateIsPlayAgainCode(isPlayAgainCode);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            System.exit(0);
        }
        return Integer.parseInt(isPlayAgainCode);
    }

    public static List<Integer> parseStringToList(String userInput) {
        List<Integer> result = new ArrayList<>();

        for (char number : userInput.toCharArray()) {
            result.add(number - '0');
        }
        return result;
    }
}
