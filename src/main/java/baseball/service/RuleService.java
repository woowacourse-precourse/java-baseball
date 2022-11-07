package baseball.service;

import java.util.List;

public class RuleService {
    public int countStrike(List<Integer> randomNumber, List<Integer> inputNumber) {
        int cnt = 0;

        for (int idx = 0; idx < randomNumber.size(); idx++) {
            if (randomNumber.get(idx) == inputNumber.get(idx)) {
                cnt++;
            }
        }

        return cnt;
    }

    public int countBall(List<Integer> randomNumber, List<Integer> inputNumber) {
        int cnt = 0;

        for (int idx = 0; idx < inputNumber.size(); idx++) {
            if (randomNumber.contains(inputNumber.get(idx)))
                cnt++;
        }

        return cnt - countStrike(randomNumber, inputNumber);
    }

}
