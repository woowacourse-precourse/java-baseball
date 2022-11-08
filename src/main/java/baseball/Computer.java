package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    int correct_answer;

    public void setRandom() { //컴퓨터가 난수를 생성하는 기능
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (list.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(random)) {
                list.add(random);
                sb.append(random);
            }
        }
        int answer = Integer.parseInt(String.valueOf(sb));
        correct_answer = answer;
    }
}
