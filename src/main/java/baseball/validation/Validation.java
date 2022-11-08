package baseball.validation;

import static baseball.util.Constant.*;

import java.util.ArrayList;
import java.util.List;


public class Validation {

    //플레이어가 제시한 숫자의 길이를 검증하는 기능
    public boolean checkAnswerLength(String answer) {
        return answer.length() == ANSWER_LENGTH;
    }

    //플레이어가 제시한 숫자가 1부터 9사이의 수로 구성되어있는지 검증 기능
    public boolean checkAnswerConsistOfNum(String answer) {
        return answer.matches(CONSIST_OF_NUM);
    }

    //플레이어가 제시한 숫자가 서로 다른 수로 구성되어있는지 검증 기능
    public boolean checkAnswerOverlap(String answer) {
        List<Character> check = new ArrayList<>();
        for (char num : answer.toCharArray()) {
            if (check.contains(num)) {
                return false;
            }
            check.add(num);
        }
        return true;
    }

    //플레이어가 제사한 숫자에 대한 통합 검증 기능
    public void checkAnswerValidation(String answer) {
        if (!checkAnswerLength(answer)) {
            throw new IllegalArgumentException(ERROR_LENGTH_THREE);
        } else if (!checkAnswerConsistOfNum(answer)) {
            throw new IllegalArgumentException(ERROR_CONSIST_OF_NUM);
        } else if (!checkAnswerOverlap(answer)) {
            throw new IllegalArgumentException(ERROR_OVERLAP_NUM);
        }
    }

    //플레이어가 재시작 및 종료 응답을 검증하는 기능
    public void checkRestartOrExitValidation(String reply) {
        if(!(reply.equals("1") || reply.equals("2"))){
            throw new IllegalArgumentException(ERROR_INPUT);
        }
    }
}
