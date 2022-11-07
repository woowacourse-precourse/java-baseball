package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final String ANSWER;

    public Computer() {
        ANSWER = drawNumber();
    }

    private String drawNumber() {
        List<String> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(String.valueOf(number))) {
                randomNumbers.add(String.valueOf(number));
            }
        }
        String randomNumber = String.join("", randomNumbers);
        return randomNumber;
    }
    public String getANSWER(){
        return ANSWER;
    }
}
