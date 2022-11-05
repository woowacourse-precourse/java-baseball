package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerNumber {

    private static final int LENGTH = 3;

    // 중복 확인하기
    int checkDuplication(int[] answer, int randomNum) {
        for (int i = 0; i < LENGTH; i++) {
            if (randomNum == answer[i]) {
                randomNum = 0;
                break;
            }
        }
        return randomNum;
    }

    public AnswerNumber() {}
}
