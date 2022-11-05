package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GetNumber {
    private static final int DIGIT_NUMBER = 3;

    public List<Integer> user() {
        List<Integer> userNumber = new ArrayList<>();

        System.out.print(GameMessage.input);
        String inputStringNumber = Console.readLine();

        for (int userIndex = 0; userIndex < inputStringNumber.length(); userIndex++) {
            int number = inputStringNumber.charAt(userIndex) - '0';

            if (!userNumber.contains(number)) {
                userNumber.add(number);
            }
        }

        return userNumber;
    }

    public void userException(List<Integer> user) {
        if (user.size() != DIGIT_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
