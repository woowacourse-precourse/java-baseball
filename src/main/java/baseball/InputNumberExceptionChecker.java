package baseball;

public class InputNumberExceptionChecker {
    // 3글자가 아닐 때
    public static boolean isValidLength(String number) {
        if (number.length() != 3) {
            return false;
        } else {
            return true;
        }
    }

    // 모두 다른 수가 아닐 때
    public static boolean hasDifferentNumberElement(String number) {
        if (number.charAt(0) == number.charAt(1)
                || number.charAt(1) == number.charAt(2)
                || number.charAt(2) == number.charAt((0))) {
            return false;
        } else {
            return true;
        }
    }

    // 숫자에 0이 들어갔을 때
    public static boolean hasZero(String number) {
        if (number.charAt(0) == '0'
                || number.charAt(1) == '0'
                || number.charAt(2) == '0') {
            return false;
        } else {
            return true;
        }
    }

    // 재시작 여부에, 1과 2가 아닌 다른 숫자를 입력했을 때
    public static boolean isValidRestartNumber(int restartNumber) {
        if (restartNumber != 1 && restartNumber != 2) {
            return false;
        } else {
            return true;
        }
    }

    // String type을 parameter로 받아서 판단
    public static boolean hasException(String number) {
        if (isValidLength(number) && hasDifferentNumberElement(number) && hasZero(number)) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // int type을 parameter로 받아서 판단
    public static boolean hasException(int restartNumber) {
        if (isValidRestartNumber(restartNumber)) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
