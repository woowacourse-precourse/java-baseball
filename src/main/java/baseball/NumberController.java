package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.regex.Pattern;

public class NumberController {
    static final int MAX_NUMBER_OF_RANGE = 9;
    static final int MIN_NUMBER_OF_RANGE = 1;
    static final int MAX_NUMBER_OF_DIGIT = 3;

    private NumberController() {
    }

    public static boolean isStringNumberInRange(String input, int start, int end) {
        String range = String.format("^[%d-%d]*$",start, end);

        return (Pattern.matches(range, input) && input != null);
    }

    public static List<Integer> getUniqueThreeNumbers() {
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() < MAX_NUMBER_OF_DIGIT) {
            int tempNum = Randoms.pickNumberInRange(MIN_NUMBER_OF_RANGE,MAX_NUMBER_OF_RANGE);
            if (!numberList.contains(tempNum)) {
                numberList.add(tempNum);
            }
        }
        return numberList;
    }

    public static List<Integer> getStrikesAndBalls(List<Integer> users, List<Integer> computers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(computers.get(i))) {
                strikes++;
                continue;
            }
            if (computers.contains(users.get(i))) {
                balls++;
            }
        }
        return List.of(strikes, balls);
    }

    public static List<Integer> convertStringToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char numChar : input.toCharArray()) {
            numbers.add(Character.getNumericValue(numChar));
        }
        return numbers;
    }
}
