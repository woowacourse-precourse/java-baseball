package baseball;

import static baseball.utils.Constant.GAME_NUMBER_SIZE;

import java.util.ArrayList;
import java.util.List;

public class StrikeAndBall {

    DefenceNumberMaker defenceNumberMaker;

    List<Integer> defenceNumber;
    List<Integer> offenceNumber;

    StrikeAndBall() {
        defenceNumberMaker = new DefenceNumberMaker();
    }

    public void setDefenceNumber() {
        defenceNumber = defenceNumberMaker.getDefenceNumber();
    }

    public void setOffenceNumber(List<Integer> offenceNumber) {
        this.offenceNumber = offenceNumber;
    }

    public List<Integer> getBallAndStrikeCount() {
        List<Integer> result = new ArrayList<>();
        result.add(checkBall());
        result.add(checkStrike());
        return result;
    }

    private int checkStrike() {
        int count = 0;

        for (int i = 0; i < GAME_NUMBER_SIZE; i++) {
            if (defenceNumber.get(i).equals(offenceNumber.get(i))) {
                count++;
            }
        }

        return count;
    }

    private int checkBall() {
        int count = 0;

        for (Integer number : offenceNumber) {
            int index = defenceNumber.indexOf(number);
            if (index != -1 && offenceNumber.indexOf(number) != index) {
                count++;
            }
        }
        return count;
    }
}
