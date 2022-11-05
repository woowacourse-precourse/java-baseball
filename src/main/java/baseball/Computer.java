package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    public String selectRandomNumber() {
        List<Integer> randomDigits = new ArrayList<>();
        while (randomDigits.size() != 3) {
            int randomDigit = Randoms.pickNumberInRange(1, 9);
            if (!randomDigits.contains(randomDigit))
                randomDigits.add(randomDigit);
        }
        return randomDigits.stream().map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    public Result resultOfPrediction(String randomNumber, String predictedNumber) {
        // result processor process result and return
        return new Result();
    }
}
