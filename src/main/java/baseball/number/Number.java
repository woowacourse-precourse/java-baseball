package baseball.number;

public class Number {
    private String number;

    public Number(String userNumber) {
        this.number = userNumber;
    }

    private static boolean isValidateLength(String userNumber) {
        return userNumber.length() == 3;
    }

    private static boolean isDigit(String userNumber) {
        for (char number : userNumber.toCharArray()) {
            if (!Character.isDigit(number)) {
                return false;
            }
        }
        return true;
    }
}
