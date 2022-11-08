package baseball.input.inputMember;

import camp.nextstep.edu.missionutils.Console;

public class IntInputNumber {
    private final String ONLY_NUMBER = "숫자만 입력할 수 있습니다";

    private int intInputNumber;

    public int getIntInputNumber() {
        return intInputNumber;
    }

    public IntInputNumber(String number) {
        try {
            this.intInputNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }

}
