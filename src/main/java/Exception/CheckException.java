package Exception;

import java.util.HashSet;
import java.util.Set;

public class CheckException {

    public static String restartStatusValid(String restartStatus) throws ProcessException {

        if (!(restartStatus.equals("1")) && !(restartStatus.equals("2"))) {
            throw new ProcessException("재시작 입력값이 잘못 입력되었습니다. 게임을 종료합니다.");
        }

        return restartStatus;
    }

    public static String inputGameValid(String inputValue) throws ProcessException {

        if (inputValue.length() != 3) {
            throw new ProcessException("입력값의 길이가 다릅니다. 게임을 종료합니다.");
        }

        if (!isNumeric(inputValue)) {
            throw new ProcessException("입력값의 형식이 다릅니다. 게임을 종료합니다.");
        }

        if (!isDiffAllDigits(inputValue)) {
            throw new ProcessException("입력값에 중복이 있습니다. 게임을 종료합니다.");
        }

        return inputValue;
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

        Set<Character> inputs = new HashSet<>();

        for (int index = 0; index < inputValue.length(); index++) {
            inputs.add(inputValue.charAt(index));
        }
        return inputs.size() == inputValue.length();
    }
}
