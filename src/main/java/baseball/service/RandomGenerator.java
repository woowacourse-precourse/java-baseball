package baseball.service;

import baseball.mapper.StringMapper;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomGenerator {
    private final int ANSWER_LENGTH;

    public RandomGenerator(int answerLength) {
        this.ANSWER_LENGTH = answerLength;
    }

    public String generateRandomNumbers() {
        List<String> computer = new ArrayList<>();

        while (computer.size() < answerLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String strNumber = StringMapper.itos(randomNumber);

            if (!computer.contains(strNumber)) {
                computer.add(strNumber);
            }
        }

        String generated = String.join("", computer);
        return generated;
    }
}
