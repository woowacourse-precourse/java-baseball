package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import fixed.FixedList;

public class Computer {

    private final int[] answer;

    public Computer() {
        answer = new int[FixedList.LENGTH];
    }

    public void makeAnswerNum () {
        int cnt = 0;
        while (cnt < FixedList.LENGTH) {
            int randomNum = Randoms.pickNumberInRange(1,9);
            int checkedNum = checkDuplication(randomNum);

            if (isNotDuplicated(checkedNum)) {
                answer[cnt] = randomNum;
                cnt++;
            }
        }
    }

    int checkDuplication(int randomNum) {
        for (int i = 0; i < FixedList.LENGTH; i++) {
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

    public int[] getAnswer() {
        return answer;
    }
}
