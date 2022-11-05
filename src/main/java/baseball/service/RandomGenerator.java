package baseball.service;

import baseball.mapper.StringMapper;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    public String generateRandomNumbers(int answerLength) {
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
