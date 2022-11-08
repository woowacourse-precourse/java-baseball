package baseball.logic;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class DigitNumberTest {

    @Test
    void generateDigitNumberWithoutDuplication_중복_없는_숫자_생성() {
        DigitNumber digitNumber = DigitNumber.getInstance(3);
        int test = 10_000_000;

        while (test-- > 0) {
            Map<Integer, Integer> map = digitNumber.generateDigitNumberWithoutDuplication();

            Set<Integer> checker = new HashSet<>();
            for (int key : map.keySet()) {
                checker.add(key);
            }

            assert (checker.size() == 3);
        }
    }

}
