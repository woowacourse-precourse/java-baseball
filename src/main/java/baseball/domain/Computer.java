package baseball.domain;

import baseball.model.Baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public Baseball createRandomNumber() {
        List<Integer> numbers = getRandomNumber();
        return new Baseball(numbers);
    }
    public List<Integer> getRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        // 3개의 숫자가 담길 때까지
        // 만약 이미 존재하는 숫자가 있는 경우 담지 않는다.
        // 만약 존재하는 숫자가 없는 경우 담는다.
        while (randomNumber.size() < 3) {
            int number = Randoms.pickNumberInRange(Baseball.MIN_NUM, Baseball.MAX_NUM);
            if (!randomNumber.contains(number)) {
                randomNumber.add(number);
            }
        }
        return randomNumber;
    }
}
