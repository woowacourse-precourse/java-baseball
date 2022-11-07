package game.stdiogame.numberbaseball;

import java.util.HashMap;
import java.util.Map;
import camp.nextstep.edu.missionutils.Randoms;
import game.stdiogame.SimpleStdIOGameStatus;

public class NumberBaseballStdIOGameStatus extends SimpleStdIOGameStatus {
    private final Map<Character, Integer> targetNumber;
    private int ballCount;
    private int strikeCount;

    public NumberBaseballStdIOGameStatus() {
        super();
        ballCount = 0;
        strikeCount = 0;
        targetNumber = new HashMap<Character, Integer>(3);
        putRandomNumbersToTargetNumbers();
    }

    public void changeTargetNumbers() {
        targetNumber.clear();
        putRandomNumbersToTargetNumbers();
    }

    private void putRandomNumbersToTargetNumbers() {
        int idx = 0;
        while (targetNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            targetNumber.put((char)(randomNumber+'0'), idx++);
        }
    }

    public Map<Character, Integer> getTargetNumber() {
        return targetNumber;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }
}
