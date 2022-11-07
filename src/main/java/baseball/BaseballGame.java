package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class BaseballGame {
    private ArrayList<Integer> comAnswer = new ArrayList<>();

    private void initAnswer() {
        while (comAnswer.size() < 3) {
            int randomInt = Randoms.pickNumberInRange(1, 9);

            if (comAnswer.indexOf(randomInt) == -1)
                comAnswer.add(randomInt);
        }
    }

//    public ArrayList<Integer> inputAnswer() {
//
//    }
}
