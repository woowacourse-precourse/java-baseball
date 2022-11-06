package baseball;

public class SystemOutput {

    private final int strikecount;
    private final int ballcount;

    public SystemOutput(BaseballCount baseballCount) {
        this.strikecount = baseballCount.getStrikecount();
        this.ballcount = baseballCount.getBallcount();
        baseballCountMessage();
        onlyBallMessage();
        onlyStrikeMessage();
        allNotSameMessage();
    }

    public static void allStrikeMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void baseballCountMessage() {
        if (strikecount != 0 && ballcount != 0) {
            System.out.println(ballcount + "볼 " + strikecount + "스트라이크");
        }

    }

    private void onlyBallMessage() {
        if (strikecount == 0 && ballcount != 0) {
            System.out.println(ballcount + "볼");
        }

    }

    private void onlyStrikeMessage() {
        if (strikecount != 0 && ballcount == 0) {
            System.out.println(strikecount + "스트라이크");
        }
    }

    private void allNotSameMessage() {
        if (strikecount == 0 && ballcount == 0) {
            System.out.println("낫싱");
        }
    }


}
