package baseball;

import java.util.List;

/**
 * MultiDigitNumber 간의 비교 비교 결과를 담는 컨테이너 클래스
 */
public class CompareResult {

    private List<List<String>> compareResult;

    /**
     * CompareResult 객체 생성자
     *
     * @param compareResult <br>
     * ex)[[스트라이크,1],[볼,2]] or [[낫싱]]
     */
    public CompareResult(List<List<String>> compareResult){
        this.compareResult = compareResult;
    }

    /**
     * @return CompareResult 객체를 문자열 형태로 반환
     */
    public String toString(){
        StringBuilder outputString = new StringBuilder();

        for(List<String> result : compareResult){
            if(outputString.length() != 0){
                outputString.append(" ");
            }

            for(String part : result) {
                outputString.append(part);
            }
        }
        return outputString.toString();
    }
}
