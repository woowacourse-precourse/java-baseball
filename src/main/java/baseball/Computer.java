package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNumbers = new ArrayList<>();

    public Computer() {
        setRandomNum();
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    /**
     * 3개의 1부터 9까지 서로 다른 수로 이루어진 랜덤 숫자를 생성하는 메소드
     */
    private void setRandomNum() {
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }
}
