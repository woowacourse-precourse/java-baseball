package baseball.constant;

public enum Want {
    MORE("1"),
    FINISH("2");

    private final String str;

    Want(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
