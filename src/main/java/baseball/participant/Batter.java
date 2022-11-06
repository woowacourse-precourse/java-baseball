package baseball.participant;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Batter {

    public String readyRandomNumber() {
        List<Integer> randomDigits = new ArrayList<>();
        while (randomDigits.size() != 3) {
            readyRandomDigit(randomDigits);
        }
        return randomDigits.stream().map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    private void readyRandomDigit(List<Integer> randomDigits) {
        int randomDigit = Randoms.pickNumberInRange(1, 9);
        if (!randomDigits.contains(randomDigit)) {
            randomDigits.add(randomDigit);
        }
    }
}
