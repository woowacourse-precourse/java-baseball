package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {

    private static final int ANSWER_LENGTH = 3;

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static String setAnswer() {
        List<Integer> randomNumberList = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, ANSWER_LENGTH); // 1 ~ 9까지 서로 다른 임의의 수 3개를 선택
        return randomNumberList.toString().replaceAll("[^0-9]", "");
    }

    public static boolean checkPredictInput_regex(String predictInput) {
        String regex = "[1-9]{" + (ANSWER_LENGTH) + "}$"; // 각각 1 ~ 9의 범위를 가지는 3자리 숫자
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(predictInput);
        return matcher.matches();
    }

    public static boolean checkPredictInput_duplicate(String predictInput) {
        Set<Character> predictInputSet = new HashSet<>();
        for (int i = 0; i < predictInput.length(); i++) {
            predictInputSet.add(predictInput.charAt(i));
        }

        // 중복된 숫자가 없었을 경우 Set의 크기는 3
        return predictInputSet.size() == 3;
    }

    public static boolean checkRepeatInput_regex(String repeatInput) {
        String regex = "^[1-2]$"; // 1 또는 2
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(repeatInput);
        return matcher.matches();
    }

}
