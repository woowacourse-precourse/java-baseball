package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class InGame {
    private final BaseballUtil baseballUtil;
    private final int answer;

    public InGame() {
        this.baseballUtil = new BaseballUtil();
        this.answer = this.createRandomInt();
    }
    public InGame(BaseballUtil baseballUtil) {
        this.baseballUtil = baseballUtil;
        this.answer = this.createRandomInt();
    }

    public InGame(BaseballUtil baseballUtil, int number) {
        this.baseballUtil = baseballUtil;
        this.answer = number;
    }

    public boolean playGame() {
        return true;
    }

    private int createRandomInt() {
        int random_int = 0;

        List<Integer> random_pick = Randoms.pickUniqueNumbersInRange(0, 9, 3);

        for(int i = 0; i < 3; i++) {
            random_int *= 10;
            random_int += random_pick.get(i);
        }

        return random_int;
    }

    private void announceUserInput() {

    }

    private void announceInputResult() {

    }

    private int getUserInput() {
        return 0;
    }

    private boolean userInputValidation() {
        return true;
    }

    private int compareUserInput() {
        return 0;
    }
}
