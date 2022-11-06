package baseball;

import camp.nextstep.edu.missionutils.Randoms;

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
        return 0;
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
