package baseball.util;

public class InputConverter {

    public static int stringToInteger(String inputString) throws IllegalArgumentException {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(inputString);
    }
}
