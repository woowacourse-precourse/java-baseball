package baseball.constant;

import java.util.Arrays;

public enum Finish {

    RESTART("1"), EXIT("2");

    private String code;

    Finish(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Finish getFinishByCode(String code) {
        return Arrays.stream(values()).filter(finish -> {
                    return finish.getCode().equals(code);
                }).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
