package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> createTargetNumber() {
        int hundreds = Randoms.pickNumberInRange(1, 9);
        int tens = createTensDifferentFrom(hundreds);
        int ones = createOnesDifferentFrom(hundreds, tens);
        return List.of(hundreds, tens, ones);
    }

    public static int createTensDifferentFrom(int hundreds) {
        while (true) {
            int tens = Randoms.pickNumberInRange(1, 9);
            if (hundreds != tens)
                return tens;
        }
    }

    public static int createOnesDifferentFrom(int hundreds, int tens) {
        while (true) {
            int ones = Randoms.pickNumberInRange(1, 9);
            if (hundreds != ones && tens != ones)
                return ones;
        }
    }

    public static void validateGuessedNumber(String input) throws IllegalArgumentException {
        if (!Pattern.matches("[1-9]{3}", input)) {
            throw new IllegalArgumentException();
        }
        char hundreds = input.charAt(0);
        char tens = input.charAt(1);
        char ones = input.charAt(2);

        if (hundreds == tens || tens == ones || ones == hundreds) {
            throw new IllegalArgumentException();
        }
    }
}