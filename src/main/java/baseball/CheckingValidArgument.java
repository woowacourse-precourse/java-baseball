package baseball;

public class CheckingValidArgument {
    private final int maxNumberSize = 3;

    // 세자리 숫자인지 점검
    public void isMaxSize(String number) throws IllegalArgumentException {
        if (number.length() != maxNumberSize) {
            throw new IllegalArgumentException();
        }
    }

    // 올바른 숫자가 입력됐는지 점검
    public void isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
