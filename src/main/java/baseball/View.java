package baseball;

public class View {

    public static void start() {
        System.out.println("숫자야구 게임을 시작합니다.");
    }

    public static void end(int strikeCount) {
        System.out.printf("%d스트라이크\n", strikeCount);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void ballAndStrike(int ballCount, int strikeCount) {
        System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
    }

    public static void ball(int ballCount) {
        System.out.printf("%d볼\n", ballCount);
    }

    public static void strike(int strikeCount) {
        System.out.printf("%d스트라이크\n", strikeCount);
    }

    public static void nothing() {
        System.out.println("낫싱");
    }
}
