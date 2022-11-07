package baseball;

public class View {

    public static void start() {
        System.out.println(GameMessage.START.getMessage());
    }

    public static void inputNumber() {
        System.out.print("숫자를 입력하세요 : ");
    }

    public static void end() {
        strike(3);
        System.out.println(GameMessage.END.getMessage());
        System.out.println(GameMessage.RESTART_OR_END.getMessage());
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
        System.out.println(GameMessage.NOTHING.getMessage());
    }
}
