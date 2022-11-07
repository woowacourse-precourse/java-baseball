package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        String computerNumbers = getRandomNumbers(3);
        String userNumbers = readLine();
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
}

