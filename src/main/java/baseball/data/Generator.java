package baseball.data;

import baseball.GameConstant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Generator {
    public static List<Integer> generateAnswer() {
        Set<Integer> answers = new HashSet<>();

        while(answers.size() < GameConstant.DIGIT.getValue()) {
            answers.add(getRandomNumber());
        }

        return answers.stream().collect(Collectors.toList());
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(GameConstant.MIN.getValue(), GameConstant.MAX.getValue());
    }
}
