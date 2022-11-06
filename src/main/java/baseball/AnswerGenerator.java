package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {

    public static List<String> generateRandNum() {
        List<String> computer = new ArrayList<>();
        while (computer.size() < View.MAX_BALL_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(View.MIN_INPUT_NUMBER, View.MAX_INPUT_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(String.valueOf(randomNumber));
            }
        }
        return computer;
    }
}
