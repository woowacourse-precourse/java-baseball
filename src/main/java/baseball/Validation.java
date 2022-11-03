package baseball;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    private static final Pattern IsOnlyNumber = Pattern.compile("^[0-9]*?");
    public void InputValid(List<Integer> RandomList, List<Integer> inputList) {
        /**
         * 3자리 숫자가 입력되어야 함 -> 3자리가 아니면 예외 처리
         * 각 자리의 숫자가 달라야 함
         * 숫자가 아닐 경우 예외 처리
         * 만약 3이 아닌 다른 크기로 변경되었을 경우에도 코드 수정을 최소화 할 수 있도록
         */

        if (inputList.size() != RandomList.size() ||
                IsOnlyNumber.matcher(inputList.toString()).matches()) {
            throw new IllegalArgumentException("입력값이 잘못 되었습니다.");
        }

        for(int idx = 0; idx < inputList.size() - 1; idx++) {
            for (int compare = idx+1; compare < inputList.size(); compare++) {
                if (inputList.get(idx) == inputList.get(compare))
                    throw new IllegalArgumentException("입력값이 잘못 되었습니다.");
            }
        }
    }
}
