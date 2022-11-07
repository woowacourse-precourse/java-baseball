package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> list;

    public Computer() {
        this.list = new ArrayList<>();
    }

    public void initNumbers() {
        // 서로다른 3개의 값 추출
        list.clear();
        while (list.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(number)) list.add(number);
        }
    }

    public Integer[] checkingNumbers(List<Integer> inputList) {
        Integer[] answer = new Integer[]{0, 0};

        // checking - strike
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < inputList.size(); j++) {
                if (list.get(i).equals(inputList.get(j))) {
                    // strike or ball
                    if (i == j) answer[0]++;
                    else answer[1]++;
                }
            }
        }
        return answer;
    }
}
