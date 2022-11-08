package baseball.bo;

public class ExitFlag {
    static final int INITIAL_FLAG = 1;
    public static final int FINISH_FLAG = 2;

    private int exitFlag;

    public ExitFlag() {
        this.exitFlag = INITIAL_FLAG;
    }

    public void setExitFlag(String input) {
        validateFlagNum(input);
        this.exitFlag = Integer.parseInt(input);
    }

    public int getExitFlag() {
        return this.exitFlag;
    }

    private static void validateFlagNum(String input) {
        if (!input.matches("^[1-9]+$")
                || !(Integer.parseInt(input) == 1 || Integer.parseInt(input) == 2)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }



}
