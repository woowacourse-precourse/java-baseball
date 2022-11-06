package baseball.number;

public class Number {
    private String number;

    public Number(String number) {
        this.number = number;
    }

    private static boolean validateLength(String number) {
            return number.length() == 3;
    }


}
