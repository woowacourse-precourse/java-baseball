package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Computer {
    private String answer;

    public String getAnswer() {
        return answer;
    }

    /**
     * 도메인 로직
     */
    public void setAnswerByRandom() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        this.answer = randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
