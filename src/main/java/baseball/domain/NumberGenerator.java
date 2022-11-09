package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<Integer> createRandomNumbers() {
        // 3개의 숫자가 담길 떄까지
        // 만약 이미 존재하는 숫자라면 담지 않는다.
        // 만약 존재하지 안흔 숫자라면 담는다.
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);;

            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        return numbers;
    }
}
