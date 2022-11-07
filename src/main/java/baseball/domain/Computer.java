package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Computer {
    private final String answer;

    public Computer() {
        this.answer = setAnswerByRandom();
    }

    public String getAnswer() {
        return answer;
    }

    /**
     * 도메인 로직
     */
    private String setAnswerByRandom() {
        Set<Integer> included = new HashSet<>();
        ArrayList<Integer> randomNumbers = new ArrayList<>();

        while (included.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!included.contains(randomNumber)) {
                included.add(randomNumber);
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
