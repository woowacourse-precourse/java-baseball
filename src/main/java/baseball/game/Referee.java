package baseball.game;


import baseball.constant.Accuracy;
import baseball.constant.Rules;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseball.constant.Rules.PICK_COUNT;

public class Referee {

    public boolean isPerfectAnswer(List<Integer> targetNumbers, List<Integer> userNumbers) {
        validateNumbersLength(targetNumbers, userNumbers);

        Map<Accuracy, Integer> judgeAccuracy = getJudgeAccuracy();
        shout(judgeAccuracy);

        return judgeAccuracy.get(Accuracy.CORRECT_ANSWER) == PICK_COUNT;
    }
}
