package baseball.number;

public class Number {
    private String number;

    public Number(String number) {
        this.number = number;
    }

    private static boolean validateLength(String number) {
        if (number.length() != 3) {
            return false;
        }
        return true;
    }


}
