package baseball.players;

import static baseball.settings.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {
    public static List<Integer> createThreeDigitNumber() {
        List<Integer> digits = new ArrayList<>();

        while (digits.size() < NUMBER_OF_DIGITS) {
            addNewDigit(digits);
        }
        return digits;
    }

    public static void addNewDigit(List<Integer> digits) {
        int newDigit = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);

        digits.add(newDigit);
        digits.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
