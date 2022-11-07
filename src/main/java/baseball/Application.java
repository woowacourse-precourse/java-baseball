package baseball;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        List<Integer> computerNumbers = getRandomNumbers(3);
        System.out.println(computerNumbers);
    }

    private static List<Integer> getRandomNumbers(int numbers) {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < numbers) {
            Integer tempNumber = pickNumberInRange(1, 9);
            if (!randomNumbers.contains(tempNumber)) {
                randomNumbers.add(tempNumber);
            }
        }
        return randomNumbers;
    }
}


