package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumComputerPicker {
    private static final int NUMBER_OF_DIGIT = 3;

    public static int pickNumComputer() {
        int numComputer = -1;
        do {
            numComputer = Randoms.pickNumberInRange(100, 999);
        } while (!validateNumComputer(numComputer));

        return numComputer;
    }

    public static boolean validateNumComputer(int numComputer) {
        Set<Integer> set = new HashSet<>();
        set.addAll(getDigitsFromNumber(numComputer));

        return (set.size() == NUMBER_OF_DIGIT) && (100 <= numComputer && numComputer <= 999) && (!set.contains(0));
    }

    private static List<Integer> getDigitsFromNumber(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }

        return digits;
    }
}
