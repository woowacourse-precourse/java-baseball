package baseball;

public class CheckException {

    public static boolean restartStatusValue(String restartStatus) {

        return !(restartStatus.equals("1") || restartStatus.equals("2"));
    }

    public static boolean inputGameValue(String inputValue) {

        if (inputValue.length() != 3) return false;

        if (!isNumeric(inputValue)) return false;

        if(!isDiffAllDigits(inputValue)) return false;

        return true;
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

        if(inputValue.charAt(0) == inputValue.charAt(1)) return false;

        if(inputValue.charAt(1) == inputValue.charAt(2)) return false;

        if (inputValue.charAt(0) == inputValue.charAt(2)) return false;

        return true;
    }
}