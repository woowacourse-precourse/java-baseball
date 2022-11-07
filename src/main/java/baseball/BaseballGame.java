package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class BaseballGame {
    private ArrayList<Integer> comAnswer = new ArrayList<>();

    public void initAnswer() {
        while (comAnswer.size() < 3) {
            int randomInt = Randoms.pickNumberInRange(1, 9);

            if (comAnswer.indexOf(randomInt) == -1)
                comAnswer.add(randomInt);
        }
        System.out.println(comAnswer);
    }
}
