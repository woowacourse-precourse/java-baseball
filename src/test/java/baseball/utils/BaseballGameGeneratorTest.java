package baseball.utils;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseballGameGeneratorTest {

    @RepeatedTest(value = 10)
    void 서로_다른_세자리_숫자_생성_성공() {
        String baseballNumber = BaseballNumberGenerator.generateNumber();
        Set<Character> list = baseballNumber.chars().mapToObj(i -> (char) i).collect(Collectors.toSet());

        assertEquals(3, list.size());
    }
}
