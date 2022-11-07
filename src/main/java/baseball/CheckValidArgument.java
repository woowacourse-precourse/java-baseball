package baseball;

public class CheckValidArgument {
    private final int MAX_NUMBER_SIZE = 3;

    // 세자리 숫자인지 점검
    public void isMaxSize(String number) throws IllegalArgumentException {
        if (number.length() != MAX_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // 올바른 숫자가 입력됐는지 점검
    public void isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
