package baseball;

import java.util.ArrayList;
import java.util.List;

public class StrikeAndBall {

    int gameNumberSize;
    DefenceNumberMaker defenceNumberMaker;

    List<Integer> defenceNumber;
    List<Integer> offenceNumber;

    StrikeAndBall(int size) {
        this.gameNumberSize = size;
        defenceNumberMaker = new DefenceNumberMaker(gameNumberSize);
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

        for (int i = 0; i < gameNumberSize; i++) {
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
