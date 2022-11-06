package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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
