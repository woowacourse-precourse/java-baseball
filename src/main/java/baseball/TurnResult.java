package baseball;

public class TurnResult {

    private final BaseballNum baseballNum;
    private final int inputNum;

    private int balls = 0;
    private int strikes = 0;

    private TurnResult(BaseballNum baseballNum, int inputNum) {
        this.baseballNum = baseballNum;
        this.inputNum = inputNum;
        proceedCmp();
    }

    public static TurnResult compare(BaseballNum baseballNum, int inputNum) {
        return new TurnResult(baseballNum, inputNum);
    }

    private void proceedCmp() {
        int temp = inputNum;
        for (int pos = 3; pos >= 1; pos--) {
            int num = temp % 10;
            int find = baseballNum.getIndex(num);

            if (find == pos)
                strikes++;
            else if (find != 0)
                balls++;

            temp /= 10;
        }
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    @Override
    public String toString() {
        if (balls == 0 && strikes == 0)
            return "낫싱";

        String ret = "";
        if (balls > 0)
            ret = ret + balls + "볼";
        if (strikes > 0)
            ret = ret + strikes + "스트라이크";
        return ret;
    }
}
