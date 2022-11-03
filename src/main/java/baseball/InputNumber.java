package baseball;

public class InputNumber {
    String number;

    InputNumber(String number) {
        checkStringNumberLength(number);
        checkStringNumberIsNumber(number);
        this.number = number;
    }

    public static void checkStringNumberLength(String number) {
        if (!(number.length() == 3)) {
            throw new IllegalArgumentException("입력한 숫자길이가 3이 아닙니다.");
        }
    }

    public static void checkStringNumberIsNumber(String number) {
        boolean isCheckNumber = number.chars().allMatch(Character::isDigit);

        if (!isCheckNumber) {
            throw new IllegalArgumentException("입력한 내용이 숫자가 아닙니다.");
        }
    }
}
