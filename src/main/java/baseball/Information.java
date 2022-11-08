package baseball;

public class Information {
    enum Result {
        STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

        private final String message;
        Result(String message) { this.message = message; }
    }

    enum Error {
        UNIQUE("서로 다른 수로 이루어진 숫자만 입력할 수 있습니다."),
        RANGE("1에서 9사이의 숫자만 입력할 수 있습니다."),
        SIZE("세 자리 수만 입력할 수 있습니다."),
        FLAG("1과 2 중에서만 입력할 수 있습니다.");

        private final String message;
        Error(String message) {
            this.message = message;
        }
    }

    public static void throwError(Error type) {

    }

    public static String createComparisonMessage(int ballCount, int strikeCount) {

    }
}
