package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        String computerNumbers = getRandomNumbers(3);
        String userNumbers = readLine();
        checkUserNumbersValidation(userNumbers);
    }

    private static String getRandomNumbers(int numbers) {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < numbers) {
            Integer tempNumber = pickNumberInRange(1, 9);
            if (!randomNumbers.contains(tempNumber)) {
                randomNumbers.add(tempNumber);
            }
        }
        return randomNumbers.toString();
    }

    private static void checkUserNumbersValidation(String userNumbers) {
        if (userNumbers.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        try {
            Integer.parseInt(userNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}

