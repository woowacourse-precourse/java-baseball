package baseball.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    /**
     * 1~9까지 서로 다른 수로 이루어진 3자리의 컴퓨터 수를 생성한다.
     */
    protected List<Integer> createComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() != 3) {
            int randomNumber = pickNumberInRange(1, 9);

            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }
}
