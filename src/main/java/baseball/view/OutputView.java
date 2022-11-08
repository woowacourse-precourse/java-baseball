package baseball.view;

public class OutputView {
    public static void NothingOutput() {
        System.out.println("낫싱");
    }

    public static void BallOutput(int ball) {
        System.out.println(ball+"볼");
    }

    public static void StrikeOutput(int strike) {
       System.out.println(strike+"스트라이크");
    }

    public static void BallStrikeOutput(int ball, int strike) {
        System.out.println(ball+"볼 "+strike+"스트라이크");
    }

    public static void EndGameOutput() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
