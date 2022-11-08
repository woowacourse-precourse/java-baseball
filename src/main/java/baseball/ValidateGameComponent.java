package baseball;

public class ValidateGameComponent {
    public static boolean validNumberLength(String baseballNumber) {
        if (baseballNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean validNumberOutRange(String baseballNumber) {
        char[] userInputList = baseballNumber.toCharArray();
        for (char userChar : userInputList) {
            if (userChar < '1' || userChar > '9') {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
}
