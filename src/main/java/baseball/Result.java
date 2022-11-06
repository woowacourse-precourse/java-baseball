package baseball;

import java.util.Arrays;

public enum Result {
    THREESTRIKE(30, "3스트라이크"),
    TWOSTRIKE(20, "2스트라이크"),
    ONESTRIKE(10, "1스트라이크"),
    ONEBALLTWOSTRIKE(21,"1볼 2스트라이크"),
    TWOBALLONESTRIKE(12, "2볼 1스트라이크"),
    ONEBALLONESTRIKE(11, "1볼 1스트라이크"),
    THREEBALL(3, "3볼"),
    TWOBALL(2, "2볼"),
    ONEBALL(1, "1볼"),
    NOTHING(0, "낫싱");

    private int score;
    private String message;

    Result(int score, String message) {
        this.score = score;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    /*
     * 숫자 야구 결과(점수)에 대한 Result 반환
     * 점수가 음수이거나, 정의한 enum에 없다면 IllegalArgumentException 던짐
     *
     * @return String
     * */
    public static Result getResultByCode(int score) {
        return Arrays.stream(Result.values())
                .filter(result -> result.score == score)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 점수입니다."));
    }
}
