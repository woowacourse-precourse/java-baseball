package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import details.Detail;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> answer;

    public Computer() {
        answer = new ArrayList<>();
    }

    public void makeAnswerNum() {
        while (answer.size() < Detail.LENGTH) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            int checkedNum = checkDuplication(randomNum);

            if (isNotDuplicated(checkedNum)) {
                answer.add(randomNum);
            }
        }
    }

    int checkDuplication(int randomNum) {
        for (Integer integer : answer) {
            if (randomNum == integer) {
                randomNum = Detail.DUPLICATED;
                break;
            }
        }
        return randomNum;
    }

    boolean isNotDuplicated(int n) {
        return n != Detail.DUPLICATED;
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
