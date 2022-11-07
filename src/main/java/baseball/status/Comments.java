package baseball.status;

public enum Comments {

    EXCEPTION("잘못된 입력입니다. 애플리케이션을 종료합니다.");

    private final String comment;

    Comments(final String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
