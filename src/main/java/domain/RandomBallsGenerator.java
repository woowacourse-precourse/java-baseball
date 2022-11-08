package domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import camp.nextstep.edu.missionutils.Randoms;
import domain.BallsGenerator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomBallsGenerator implements BallsGenerator {
    private final int maxLen;

    public RandomBallsGenerator(int maxLen) {
        this.maxLen = maxLen;
    }

    public String generateBalls(final int startInclusive, final int endInclusive) {
        return getRandomNumbers(startInclusive, endInclusive);
    }
    public String getRandomNumbers(final int startInclusive, final int endInclusive) {
        String res = setRandomNumbers(startInclusive, endInclusive);
        return res;
    }
    public String setRandomNumbers(final int startInclusive, final int endInclusive) {
        StringBuilder randomNumbers = new StringBuilder();
        int randomNumber;

        while (randomNumbers.length() != maxLen) {
             randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (!randomNumbers.toString().contains(String.valueOf(randomNumber))) {
                randomNumbers.append(randomNumber);
            }
        }
        return randomNumbers.toString();
    }
}
