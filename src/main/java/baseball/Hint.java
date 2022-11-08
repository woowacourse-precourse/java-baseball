package baseball;

import java.util.ArrayList;
import java.util.List;

public class Hint {
    List<Integer> opponentNum = new ArrayList<>();
    List<Integer> inputNum = new ArrayList<>();
    int strike;
    int ball;

    Hint(List<Integer> opponentNum, List<Integer> inputNumList) {
        this.opponentNum.addAll(opponentNum);
        this.inputNum.addAll(inputNumList);
    }

    private boolean checkStrike(int index) {
        if (inputNum.get(index) == opponentNum.get(index)) {
            strike++;
            return true;
        }
        return false;
    }

    private void checkBall(int index) {
        for (int i = 0; i < opponentNum.size(); i++) {
            if (inputNum.get(index) == opponentNum.get(i)) {
                ball++;
                return;
            }
        }
    }

    public void checkHint() {
        for (int i = 0; i < inputNum.size(); i++) {
            if (!checkStrike(i)) {
                checkBall(i);
            }
        }
    }
}
