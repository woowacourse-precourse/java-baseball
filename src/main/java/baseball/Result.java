package baseball;

public class Result {
    StringBuilder sb;

    public void convertToString(int ball, int strike) {
        sb = new StringBuilder();
        if (ball > 0) {
            sbAppend(ball, "볼");
        }
        if (strike > 0) {
            sbAppend(strike, "스트라이크");
            isThree(strike);
        }
        isNothing(ball, strike);
    }

    public void sbAppend(int count, String text) {
        sb.append(count);
        sb.append(text + " ");
    }

    public void isThree(int strike) {
        if (strike == 3) {
            sb.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public void isNothing(int ball, int strike) {
        if(ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
