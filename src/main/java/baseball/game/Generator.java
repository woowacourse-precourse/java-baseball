package baseball.game;

import baseball.constant.GameConstant;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Generator {
    public static List<Integer> generateAnswer() {
        List<Integer> numbers;
        Set<Integer> answers = new LinkedHashSet<>();

        while(answers.size() < GameConstant.DIGIT.getValue()) {
            answers.add(getRandomNumber());
        }

        numbers = answers.stream().collect(Collectors.toList());

        Validator.isValidNumber(numbers);

        return numbers;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(GameConstant.MIN.getValue(), GameConstant.MAX.getValue());
    }
}
