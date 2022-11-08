package baseball.message;

public final class GameMessage {

    private GameMessage() {}

    // 볼과 스트라이크가 둘 다 있는 경우의 힌트메세지
    public static String ballAndStrikeMessage(int ball, int strike) {
        return ball + "볼 " + strike + "스트라이크";
    }

    // 볼만 있는 경우의 힌트메세지
    public static String ballMessage(int ball) {
        return ball + "볼";
    }

    // 스트라이크만 있는 경우의 힌트메세지
    public static String strikeMessage(int strike) {
        return strike + "스트라이크";
    }

    // 볼과 스트라이크 둘 다 없는 경우의 힌트메세지
    public static String nothingMessage() {
        return "낫싱";
    }
}
