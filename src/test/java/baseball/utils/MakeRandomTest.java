package baseball.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

class MakeRandomTest {

    MakeRandom makeRandom = MakeRandom.getInstance();

    @Test
    @DisplayName("랜덤한 세 개의 숫자가 중복되지 않게 만들어지는지 테스트")
    void randomNumbersTest() {
        // given
        List<Integer> numbers = makeRandom.numbers();

        // expected
        Assertions.assertEquals(3, new HashSet<>(numbers).size());
    }

    @Test
    @DisplayName("각 숫자가 1~9에 해당하는가")
    void randomNumbersValidationTest() {
        // given
        List<Integer> numbers = makeRandom.numbers();

        // expected
        Assertions.assertTrue(String.valueOf(numbers.get(0)).matches("[1-9]"));
        Assertions.assertTrue(String.valueOf(numbers.get(1)).matches("[1-9]"));
        Assertions.assertTrue(String.valueOf(numbers.get(2)).matches("[1-9]"));
    }
}