package baseball;

public class CheckException {

    public static boolean restartStatusValid(String restartStatus) {

        if (!(restartStatus.equals("1")) && !(restartStatus.equals("2"))) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public static void inputGameValid(String inputValue) {

        if (inputValue.length() != 3) {
            throw new IllegalArgumentException();
        }

        if (!isNumeric(inputValue)) {
            throw new IllegalArgumentException();
        }

        if (!isDiffAllDigits(inputValue)) {
            throw new IllegalArgumentException();
        }

    }

    private static boolean isNumeric(String inputValue) {

        try {
            Integer.parseInt(inputValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDiffAllDigits(String inputValue) {

        if (inputValue.charAt(0) == inputValue.charAt(1)) return false;

        if (inputValue.charAt(1) == inputValue.charAt(2)) return false;

        return inputValue.charAt(0) != inputValue.charAt(2);
    }
}