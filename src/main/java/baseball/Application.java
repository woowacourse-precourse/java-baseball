package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static int getNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static boolean isValidUserNumber(String userNumber) {
        if (userNumber.length() != 3 || userNumber.contains("0")) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
