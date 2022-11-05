package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerNumber {

    private static final int LENGTH = 3;

    // 3자리 숫자 생성하기
    public int[] getAnswerNum () {
        int[] answer = new int[LENGTH];
        int cnt = 0;

        while (cnt < LENGTH) {
            int randomNum = Randoms.pickNumberInRange(1,9);
            int checkedNum = checkDuplication(answer, randomNum);

            if (isNotDuplicated(checkedNum)) {
                answer[cnt] = randomNum;
                cnt++;
            }
        }
        return answer;
    }

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

    boolean isNotDuplicated (int n) {
        return n != 0;
    }

    public AnswerNumber() {}
}
