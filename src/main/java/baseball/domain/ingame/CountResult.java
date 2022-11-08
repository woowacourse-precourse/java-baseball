package baseball.domain.ingame;

public class CountResult {

    private final int ballCount;
    private final int strikeCount;

    CountResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean withThreeStrike() {
        return strikeCount == 3;
    }

    public String stringFormatOfCountResult() {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (0 < ballCount) {
            stringBuilder.append(ballCount).append("볼 ");
        }

        if (0 < strikeCount) {
            stringBuilder.append(strikeCount).append("스트라이크");
        }

        return stringBuilder.toString();
    }
}
