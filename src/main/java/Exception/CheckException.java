package Exception;

public class CheckException {

    public static boolean restartStatusValid(String restartStatus) throws ProgressException {

        if (!(restartStatus.equals("1")) && !(restartStatus.equals("2"))) {
            throw new ProgressException("재시작 입력값이 잘못 입력되었습니다. 게임을 종료합니다.");
        }
        return true;
    }

    public static void inputGameValid(String inputValue) throws ProgressException{

        if (inputValue.length() != 3) {
            throw new ProgressException("입력값의 길이가 다릅니다. 게임을 종료합니다.");
        }

        if (!isNumeric(inputValue)) {
            throw new ProgressException("입력값의 형식이 다릅니다. 게임을 종료합니다.");
        }

        if (!isDiffAllDigits(inputValue)) {
            throw new ProgressException("입력값에 중복이 있습니다. 게임을 종료합니다.");
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