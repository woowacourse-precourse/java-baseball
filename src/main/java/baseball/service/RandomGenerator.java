package baseball.service;

import baseball.mapper.StringMapper;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class RandomGenerator {
    private final int ANSWER_LENGTH;

    public RandomGenerator(int answerLength) {
        this.ANSWER_LENGTH = answerLength;
    }

    public String getAnswer() {
        Set<String> numberSet = generateRandomNumber();
        String answer = String.join("", numberSet);
        return answer;
    }

    private Set<String> generateRandomNumber() {
        Set<String> numberSet = new LinkedHashSet<>();

        while (numberSet.size() < ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String strNumber = StringMapper.itos(randomNumber);
            numberSet.add(strNumber);
        }

        return numberSet;
    }
}
