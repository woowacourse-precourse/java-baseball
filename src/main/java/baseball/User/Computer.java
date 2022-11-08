package baseball.User;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public int[] RandomComputer() { // 3자리 램덤수 생성

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int[] answer = new int[computer.size()];
        for (int j = 0; j < computer.size(); j++) {
            answer[j] = computer.get(j);
        }


        return answer;
    }

}