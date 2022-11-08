package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {
    private final String answer;

    public Computer() {
        this.answer = setAnswerByRandom();
    }

    public String getAnswer() {
        return answer;
    }

    private String setAnswerByRandom() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
