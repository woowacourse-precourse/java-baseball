package ballAndStrike;

import java.util.List;

public class Count {
    private int ballNumber;
    private int strikeNumber;
    public Count() {
        ballNumber = 0;
        strikeNumber = 0;
    }
    public int getBallNumber() {
        return this.ballNumber;
    }
    public int getStrikeNumber() {
        return this.strikeNumber;
    }
    public void calStrike(List<Integer> randomNumber, List<Integer> enterNumber) {
        for (int i = 0; i < 3; i++) {
            if (randomNumber.get(i) == enterNumber.get(i)) {
                strikeNumber++;
            }
        }
    }
    public void calBall(List<Integer> randomNumber, List<Integer> enterNumber) {
        for (int i = 0; i < 3; i++) {
            if(randomNumber.contains(enterNumber.get(i))) {
                ballNumber++;
            }
        }
        ballNumber -= strikeNumber;
    }
    public void resetCount() {
        strikeNumber = 0;
        ballNumber = 0;
    }
}
