package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static boolean isValidUserNumber(String userNumber) {
        if (userNumber.length() != 3 || userNumber.contains("0")) {
            throw new IllegalArgumentException();
        }
        if (!isNumber(userNumber)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
