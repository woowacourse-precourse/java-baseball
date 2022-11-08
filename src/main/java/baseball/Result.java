package baseball;

public class Result {

    private final int strikeCount;
    private final int ballCount;

    public Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isAnswer() {
        return strikeCount == 3;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (strikeCount == 0 && ballCount == 0) {
            stringBuilder.append("낫싱");
        }
        if (ballCount >= 1) {
            stringBuilder.append(ballCount).append("볼");
        }
        if (strikeCount >= 1) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(strikeCount).append("스트라이크");
        }
        return stringBuilder.toString();
    }
}
