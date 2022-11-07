package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public void randNumber() {
        List<Integer> balls = new ArrayList<>();
        while(balls.size() < 3) {
            int ball = Randoms.pickNumberInRange(1, 9);
            if(!balls.contains(ball)) { // 각 자리의 수가 서로 다른 숫자일 경우에만 추가
                balls.add(ball);
            }
        }
    }
}
