package baseball;

import java.util.Arrays;

public enum Result {
    THREESTRIKE(30, "3��Ʈ����ũ"),
    TWOSTRIKE(20, "2��Ʈ����ũ"),
    ONESTRIKE(10, "1��Ʈ����ũ"),
    TWOBALLONESTRIKE(12, "2�� 1��Ʈ����ũ"),
    ONEBALLONESTRIKE(11, "1�� 1��Ʈ����ũ"),
    THREEBALL(3, "3��"),
    TWOBALL(2, "2��"),
    ONEBALL(1, "1��"),
    NOTHING(0, "����");

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
    // negative number  or enum is not exist -> IllegalArgumentException ����
    public static Result getResult(int score) {
        return Arrays.stream(Result.values())
                .filter(result -> result.score == score)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(EXCEPTION_MESSAGE));
    }
}
