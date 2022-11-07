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

    /**
     * 기준이 되는 BaseballNum과 입력된 수를 비교하여 결과를 반환합니다.
     * @param baseballNum 기준이 되는 BaseballNum
     * @param inputNum 비교할 3자리 정수
     * @return TurnResult 객체가 반환됩니다.
     */
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

    /**
     * 볼, 스트라이크를 정해진 포맷으로 반환합니다.
     * 볼과 스트라이크 모두 0일 경우 낫싱을 반환합니다.
     * 볼 또는 스트라이크 중 하나가 0일 경우 해당 항목은 표시되지 않습니다.
     *
     * @return 낫싱 또는 x볼 y스트라이크 형태의 문자열
     */
    @Override
    public String toString() {
        if (balls == 0 && strikes == 0)
            return "낫싱";

        String ret = "";
        if (balls > 0) {
            ret = ret + balls + "볼";
        }
        if (strikes > 0) {
            if (!ret.isEmpty())
                ret = ret + " ";
            ret = ret + strikes + "스트라이크";
        }
        return ret;
    }
}
