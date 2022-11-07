package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager {

    // 각 자리의 숫자가 1 이상 ~ 9 이하인 3자리 숫자
    private static final String PREDICT_INPUT_REGEX = "[" + NumberManager.MIN_NUMBER + "-" + NumberManager.MAX_NUMBER + "]{" + NumberManager.ANSWER_LENGTH + "}$";

    // 1 또는 2
    private static final String REPEAT_INPUT_REGEX = "[1-2]*$";

    /**
     * @return 사용자가 입력한 3자리 수
     */
    public static String getPredictInput() {
        String predictInput = Console.readLine();
        if (!checkPredictInput_regex(predictInput) || !checkPredictInput_duplicate(predictInput)) {
            throw new IllegalArgumentException();
        }
        return predictInput;
    }

    /**
     * @param predictInput 사용자가 입력한 3자리 수
     * @return 정규식에 부합한다면 true / 부합하지 않는다면 false
     */
    public static boolean checkPredictInput_regex(String predictInput) {
        Pattern pattern = Pattern.compile(PREDICT_INPUT_REGEX);
        Matcher matcher = pattern.matcher(predictInput);
        return matcher.matches();
    }

    /**
     * @param predictInput 사용자가 입력한 3자리 수
     *                     중복된 숫자가 없었을 경우 Set의 크기는 3
     * @return 중복된 숫자가 존재하지 않았을 경우 true / 존재했을 경우 false
     */
    public static boolean checkPredictInput_duplicate(String predictInput) {
        Set<Character> predictInputSet = new HashSet<>();
        for (int i = 0; i < predictInput.length(); i++) {
            predictInputSet.add(predictInput.charAt(i));
        }
        return predictInputSet.size() == NumberManager.ANSWER_LENGTH;
    }

    /**
     * @return 사용자가 입력한 1자리 수
     * 1 : 게임 새로 시작 / 2 : 게임 종료
     */
    public static String getRepeatInput() {
        String repeatInput = Console.readLine();
        if (!checkRepeatInput_regex(repeatInput)) {
            throw new IllegalArgumentException();
        }
        return repeatInput;
    }

    /**
     * @param repeatInput 사용자가 입력한 1자리 수
     * @return 정규식에 부합한다면 true / 부합하지 않는다면 false
     */
    public static boolean checkRepeatInput_regex(String repeatInput) {
        Pattern pattern = Pattern.compile(REPEAT_INPUT_REGEX);
        Matcher matcher = pattern.matcher(repeatInput);
        return matcher.matches();
    }

}
