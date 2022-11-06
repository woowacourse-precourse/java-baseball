package baseball.constant;

public enum Accuracy {
    CORRECT_ANSWER("strike", "스트라이크"),
    SIMILAR_ANSWER("ball", "볼 "),
    WRONG_ANSWER("nothing", "낫싱");

    private final String judgment;
    private final String description;

    Accuracy(String judgment, String description) {
        this.judgment = judgment;
        this.description = description;
    }

    public String getJudgment() {
        return judgment;
    }

    public String getDescription() {
        return description;
    }
}
