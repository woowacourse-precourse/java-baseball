package baseball.players;

import static baseball.settings.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {
    public static List<Integer> createThreeDigitNumber() {
        List<Integer> numberWithDifferentDigits = new ArrayList<>();
        while (numberWithDifferentDigits.size() < NUMBER_OF_DIGITS) {
            addDigit(numberWithDifferentDigits);
        }
        return numberWithDifferentDigits;
    }

    public static void addDigit(List<Integer> number) {
        int digit = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        number.add(digit);
        number.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
