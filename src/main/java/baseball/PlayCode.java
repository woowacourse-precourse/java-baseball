package baseball;

public enum PlayCode {
    PLAY_AGAIN(1), EXIT(2);
    private int code;

    PlayCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
