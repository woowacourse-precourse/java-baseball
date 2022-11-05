package baseball;

public class InputNumber {
    static String number;

    InputNumber(String number) {
        checkStringNumberLength(number);
        checkStringNumberIsNumber(number);
        checkStringNumberDuplicate(number);
        InputNumber.number = number;
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

    public static void checkStringNumberDuplicate(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            performRepeatForDuplicate(number, i);
        }
    }

    public static void performRepeatForDuplicate(String number, int i) {
        for (int j = i + 1; j < number.length(); j++) {
            if (number.charAt(i) == number.charAt(j)) {
                throw new IllegalArgumentException("입력한 숫자 중 중복되는 숫자가 있습니다.");
            }
        }
    }
}
