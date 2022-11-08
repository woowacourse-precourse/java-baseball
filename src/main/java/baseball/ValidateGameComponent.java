package baseball;

public class ValidateGameComponent {
    public static boolean validNumberLength(String baseballNumber) {
        if (baseballNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
