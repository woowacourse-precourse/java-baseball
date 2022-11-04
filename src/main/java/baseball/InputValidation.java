package baseball;

public class InputValidation {

    /**
     * Validates user's input
     * @param input 사용자가 입력한 값
     * @return boolean
     * @throws IllegalArgumentException input not valid
     */
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

    /**
     * Check if input string contains only numbers
     * @param input 사용자가 입력한 값
     * @throws IllegalArgumentException input contains non-number string
     */
    private static void isIntegerStr(String input) throws IllegalArgumentException {
        char[] inputCharArr = input.toCharArray();
        for (char c : inputCharArr) {
            if (Character.getNumericValue(c) >= 10)
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    /**
     * Check if input string has any duplicate number digit
     * @param input 사용자가 입력한 값
     * @throws IllegalArgumentException input contains duplicates
     */
    private static void hasDuplicates(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.substring(i+1).indexOf(input.charAt(i)) != -1) {
                throw new IllegalArgumentException("중복된 수가 있어선 안됩니다.");
            }
        }
    }
}
