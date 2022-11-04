package baseball.randomnumber;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.config.GameConfiguration.DIGITS_FOR_THIS_GAME;

public class RandomNumberFactory {

    public static List<Integer> newRandomNumber() {
        return new RandomNumber(generateRandomNumber()).getAnswer();
    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < DIGITS_FOR_THIS_GAME) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }
}
