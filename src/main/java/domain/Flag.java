package domain;

public class Flag {
    private final String flag;

    public Flag(String flag) {
        this.flag = flag;
        validateCorrectFlag(flag);
    }

    public void validateCorrectFlag(String flag) {
        if (!(flag.equals("1") || flag.equals("2"))) {
            throw new IllegalArgumentException("재시작 / 종료 값은 1 또는 2가 되어야 합니다.");
        }
    }

    public boolean isRestart() {
        return this.flag.equals("1");
    }
}
