package baseball;

import java.util.ArrayList;
import java.util.List;

/**
 * ThreeDigitNumber 간의 비교 비교 결과를 담는 컨테이너 클래스
 */
public class NumberCompareResult {

    private List<List<String>> compareResult;

    public NumberCompareResult(int strike, int ball) {
        List<List<String>> compareResult = new ArrayList<>();

        if (ball != 0) {
            compareResult.add(List.of(String.valueOf(ball), "볼"));
        }
        if (strike != 0) {
            compareResult.add(List.of(String.valueOf(strike), "스트라이크"));
        }
        if (compareResult.size() == 0) {
            compareResult.add(List.of("낫싱"));
        }

        this.compareResult = compareResult;
    }

    /**
     * @return CompareResult 객체를 문자열 형태로 반환
     */
    public String toString() {
        StringBuilder outputString = new StringBuilder();

        for (List<String> result : compareResult) {
            if (outputString.length() != 0) {
                outputString.append(" ");
            }

            for (String part : result) {
                outputString.append(part);
            }
        }
        return outputString.toString();
    }
}
