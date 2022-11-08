package baseball;

import static baseball.Constants.MAX_NUMBER;
import static baseball.Constants.MIN_NUMBER;
import static baseball.Constants.NUMBER_LENGTH;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    /**
     * 1~9까지 서로 다른 수로 이루어진 3자리의 컴퓨터 수를 생성한다.
     */
    public List<Integer> createComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() != NUMBER_LENGTH) {
            int randomNumber = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }
}
