package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Play {
    private static final int COUNT;
    private static final Pattern PATTERN;

    static {
        COUNT = 3;
        String regex = String.format("^(?:([1-9])(?!.*\\1)){%d}$", COUNT);
        PATTERN = Pattern.compile(regex);
    }

    /**
     * Enforce class non-instantiability with private constructor.
     */
    private Play() {
        throw new AssertionError();
    }

    static int getCount() {
        return COUNT;
    }

    static List<Integer> getRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < COUNT) {
            int digit = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(digit)) {
                randomNumber.add(digit);
            }
        }
        return randomNumber;
    }

    static List<Integer> getNumberFrom(String input) {
        if (input == null || !PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
        List<Integer> givenNumber = new ArrayList<>();
        for (char digitChar : input.toCharArray()) {
            int digitInt = Character.getNumericValue(digitChar);
            givenNumber.add(digitInt);
        }
        return givenNumber;
    }
}
