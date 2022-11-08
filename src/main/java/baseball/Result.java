package baseball;

import java.util.Arrays;

public enum Result {
    THREESTRIKE(30, "3스트라이크"),
    TWOSTRIKE(20, "2스트라이크"),
    ONESTRIKE(10, "1스트라이크"),
    TWOBALLONESTRIKE(12, "2볼 1스트라이크"),
    ONEBALLONESTRIKE(11, "1볼 1스트라이크"),
    THREEBALL(3, "3볼"),
    TWOBALL(2, "2볼"),
    ONEBALL(1, "1볼"),
    NOTHING(0, "낫싱");

    private final int score;
    private final String message;
    private static final String EXCEPTION_MESSAGE = "wrong number";

    Result(int score, String message) {
        this.score = score;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    
    // get result score
    // negative number  or enum is not exist -> IllegalArgumentException 던짐
    public static Result getResult(int score) {
        return Arrays.stream(Result.values())
                .filter(result -> result.score == score)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(EXCEPTION_MESSAGE));
    }
}
