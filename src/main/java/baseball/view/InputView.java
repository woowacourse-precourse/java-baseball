package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.validator.NumberValidator.*;
import static baseball.validator.NumbersValidator.*;

public class InputView {
    public static List<Integer> getPlayerRandomNumbers() {
        OutputView.printInputMessage();
        String input = Console.readLine();

        validateDigit(input);
        validateNonNumeric(input);

        List<Integer> player = new ArrayList<>();
        for (char inputChar : input.toCharArray()) {
            validateRange(Character.getNumericValue(inputChar));
            player.add(Character.getNumericValue(inputChar));
        }
        validateDuplicateNumber(player);
        return player;
    }

    public static boolean restartOrEndGame() {
        OutputView.printRestartOrEnd();
        int startOrEnd = Integer.parseInt(Console.readLine());
        validateRestartNumber(startOrEnd);
        return startOrEnd == 1;
    }
}
