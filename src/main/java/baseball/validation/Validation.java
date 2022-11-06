package baseball.validation;

import static baseball.util.Constant.*;


public class Validation {

    /**
     * 플레이어가 제시한 숫자의 길이를 검증하는 기능
     * @param answer 플레이어가 제시한 숫자
     * @return 플레이어가 제시한 숫자의 길이가 3이면 true 아니면 false 반환
     */
    public boolean checkAnswerLength(String answer) {
        return answer.length() == ANSWER_LENGTH;
    }

    /**
     * 플레이어가 제시한 숫자가 1부터 9사이의 수로 구성되어있는지 검증 기능
     * @param answer 플레이어가 제시한 숫자
     * @return 플레이어가 제시한 숫자가 1과 9사이의 수로 구성되어있으면 true 그렇지 않으면 false 반환
     */
    public boolean checkAnswerConsistOfNum(String answer) {
        return answer.matches(CONSIST_OF_NUM);
    }

}
