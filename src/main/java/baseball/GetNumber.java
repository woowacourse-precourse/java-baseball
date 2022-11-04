package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GetNumber {
    private static final int DIGIT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public List<Integer> computer() {
        List<Integer> computerNumber = new ArrayList<>();

        do {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        } while (computerNumber.size() != DIGIT_NUMBER);

        return computerNumber;
    }

    public List<Integer> user() {
        List<Integer> userNumber = new ArrayList<>();

        String inputStringNumber = Console.readLine();

        for (int userIndex = 0; userIndex < inputStringNumber.length(); userIndex++) {
            int number = inputStringNumber.charAt(userIndex) - '0';

            if (!userNumber.contains(number)) {
                userNumber.add(number);
            }
        }

        return userNumber;
    }
}
