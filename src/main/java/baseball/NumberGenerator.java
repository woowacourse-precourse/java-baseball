package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {

    // Randoms.pickUniqueNumbersInRange(1, 9, 3); 코드를 사용해도 되는지?>>
    public void generate(List<Integer> numbers) {
        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
    }
}
