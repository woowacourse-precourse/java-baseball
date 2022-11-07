package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers;

    /**
     * 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. camp.nextstep.edu.missionutils.Randoms 라이브러리를 이용해
     * 서로 다른 임의의 수 3개를 선택한다.
     */
    public void createRandomNumbers() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void init() {
        this.numbers = new ArrayList<>();
    }

}
