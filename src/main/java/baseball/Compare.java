package baseball;

import java.util.List;

public class Compare {
    private static final int INIT_NUM = 0;
    public static final int CLEAR_NUM = 3;
    public int strike;
    public int ball;

    public Compare() {
        initNum();
    }

    private void initNum() {
        this.strike = INIT_NUM;
        this.ball = INIT_NUM;
    }

    public void startCompare(List<Integer> playerNum, List<Integer> computerNum) {
        initNum();
        for (int i = 0; i < playerNum.size(); i++) {
            int containIndex = computerNum.indexOf(playerNum.get(i));
            getJudgement(i, containIndex);
        }
        printResult();
    }

    private void getJudgement(int index, int containIndex) {
        if (index == containIndex) {
            strike++;
        } else if (containIndex > -1) {
            ball++;
        }
    }

    private int getStrikeCount() {
        return strike;
    }

    public void printResult() {
        PlayerOutputView.printResultMessage(strike, ball);
    }
}
