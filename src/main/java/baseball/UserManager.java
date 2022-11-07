package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager {

    private static final String PREDICT_INPUT_REGEX = "[" + NumberManager.MIN_NUMBER + "-" + NumberManager.MAX_NUMBER + "]{" + NumberManager.ANSWER_LENGTH + "}$";
    private static final String REPEAT_INPUT_REGEX = "[1-2]*$";


    public static String getPredictInput() {
        String predictInput = Console.readLine();
        if (!checkPredictInput_regex(predictInput) || !checkPredictInput_duplicate(predictInput)) {
            throw new IllegalArgumentException();
        }
        return predictInput;
    }

    public static boolean checkPredictInput_regex(String predictInput) {
        Pattern pattern = Pattern.compile(PREDICT_INPUT_REGEX);
        Matcher matcher = pattern.matcher(predictInput);
        return matcher.matches();
    }

    public static boolean checkPredictInput_duplicate(String predictInput) {
        Set<Character> predictInputSet = new HashSet<>();
        for (int i = 0; i < predictInput.length(); i++) {
            predictInputSet.add(predictInput.charAt(i));
        }

        // 중복된 숫자가 없었을 경우 Set의 크기는 3
        return predictInputSet.size() == NumberManager.ANSWER_LENGTH;
    }

    public static String getRepeatInput() {
        String repeatInput = Console.readLine();
        if (!checkRepeatInput_regex(repeatInput)) {
            throw new IllegalArgumentException();
        }
        return repeatInput;
    }

    public static boolean checkRepeatInput_regex(String repeatInput) {
        Pattern pattern = Pattern.compile(REPEAT_INPUT_REGEX);
        Matcher matcher = pattern.matcher(repeatInput);
        return matcher.matches();
    }

}
