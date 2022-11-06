package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    // 애플리케이션 실행
    public void run() {
        // 컴퓨터의 숫자 초기화

        // 사용자의 입력값 저장

        // 입력 값과 결과 비교

    }

    // 컴퓨터의 숫자 초기화
    public List<Integer> initAnswerNumber() {
        List<Integer> answerNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            answerNumber.add(i, Randoms.pickNumberInRange(1, 9));
            if (!checkOverlap(answerNumber, i)) {
                i--;
            }
        }
        return answerNumber;
    }

    // 초기화시 중복 검사
    public boolean checkOverlap(List<Integer> answerNumber, int i) {
        for (int j = 0; j < i; j++) {
            if (answerNumber.get(i) == answerNumber.get(j)) {
                return false;
            }
        }
        return true;
    }


}
