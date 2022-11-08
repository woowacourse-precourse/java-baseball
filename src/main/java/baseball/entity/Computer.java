package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static List<Integer> computerNumbers;

    public void createRandomNumber() {
        computerNumbers = new ArrayList<>();

        while(computerNumbers.size()<3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (computerNumbers.contains(number)) continue;
            computerNumbers.add(number);
        }
    }
    // countBallAndStrike(input): 정답과 input을 비교하여 볼, 스트라이크 개수 카운트
}
