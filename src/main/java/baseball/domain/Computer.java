package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

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

    /**
     * 도메인 로직
     */
    private String setAnswerByRandom() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        return randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
