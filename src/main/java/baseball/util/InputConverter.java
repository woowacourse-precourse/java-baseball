package baseball.util;

public class InputConverter {

    public static int stringToInteger(String inputString) throws IllegalArgumentException {
        if (inputString.matches("^[1-9]{3}$") &&
                inputString.length() == inputString.chars().distinct().count()) {
            return Integer.parseInt(inputString);
        }

        throw new IllegalArgumentException();
    }
}
