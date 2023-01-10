package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer{
    List<Integer> random;
    public Computer() { //생성자
        /* 랜덤 변수 초기화(3자리 숫자) */
        List<Integer> random = new ArrayList<>();
        while (random.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!random.contains(randomNum)) {
                random.add(randomNum);
            }
        }
        this.random=random;
    }
}