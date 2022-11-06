package baseball.domain;

import static baseball.utils.Constant.GAME_NUMBER_SIZE;

import java.util.List;

public class Referee {

    DefenceNumberMaker defenceNumberMaker;

    List<Integer> defenceNumber;
    List<Integer> offenceNumber;

    public Referee() {
        defenceNumberMaker = new DefenceNumberMaker();
    }

    public void setDefenceNumber() {
        defenceNumber = defenceNumberMaker.getDefenceNumber();
    }

    public void setOffenceNumber(List<Integer> offenceNumber) {
        this.offenceNumber = offenceNumber;
    }

    public List<Integer> getBallAndStrikeCount() {
        return List.of(checkBall(), checkStrike());
    }

    private int checkStrike() {
        int count = 0;

        for (int i = 0; i < GAME_NUMBER_SIZE; i++) {
            if (isStrike(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isStrike(int index) {
        Integer defence = defenceNumber.get(index);
        Integer offence = offenceNumber.get(index);

        if (defence.equals(offence)) {
            return true;
        }
        return false;
    }

    private int checkBall() {
        int count = 0;

        for (Integer number : offenceNumber) {
            int index = defenceNumber.indexOf(number);
            if (isBall(index, number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isBall(int index, Integer number) {
        int offence = offenceNumber.indexOf(number);
        if (index != -1 && offence != index) {
            return true;
        }
        return false;
    }
}
