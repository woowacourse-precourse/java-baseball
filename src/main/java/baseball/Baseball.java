package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Baseball {
    List<Integer> answer = new ArrayList<>();
    
    public Baseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }
}
