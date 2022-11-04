package baseball;

public class InputValidation {

    static boolean isValidInput(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자는 3 자리여야 합니다.");
        }
        if (input.contains("0")) {
            throw new IllegalArgumentException("0 을 제외한, 1 ~ 9 사이의 수로 이루어져야 합니다.");
        }
        try {
            isIntegerStr(input);
            hasDuplicates(input);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return true;
    }

    private static void isIntegerStr(String input) throws IllegalArgumentException {
        char[] inputCharArr = input.toCharArray();
        for (char c : inputCharArr) {
            if (Character.getNumericValue(c) >= 10)
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }


    private static void hasDuplicates(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.substring(i+1).indexOf(input.charAt(i)) != -1) {
                throw new IllegalArgumentException("중복된 수가 있어선 안됩니다.");
            }
        }
    }
}
