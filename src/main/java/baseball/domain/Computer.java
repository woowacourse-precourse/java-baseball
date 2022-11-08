package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 랜덤으로 숫자를 정하고 입력한 숫자에 대한 힌트를 전달해주는 컴퓨터 클래스
 */
public class Computer {
    private List<Integer> computerNumbers;

    public void createRandomNumber() {
        computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

}
