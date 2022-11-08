package baseball.status;

public enum NumberStatus {
    MAX_NUMBER(3),
    MIN_NUMBER(0),
    ANSWER_MIN_NUMBER(1),
    ANSWER_MIN_NUMBER_CHAR(49),
    ANSWER_MAX_NUMBER(9),
    ANSWER_MAX_NUMBER_CHAR(57);

    private int number;

    NumberStatus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
