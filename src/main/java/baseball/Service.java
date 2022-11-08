package baseball;

public class Service {
    private int strike, ball;

    public void compareIdxAndIncreaseScore(int comIdx, int userIdx) {
        if (userIdx == comIdx) {
            increaseScore("S");
            return;
        }
        increaseScore("B");
    }

    public void increaseScore(String type) {
        if (type.compareTo("S") == 0) {
            strike++;
            return;
        }
        ball++;
    }
}
