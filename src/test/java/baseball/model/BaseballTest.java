package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

class BaseballTest {

    @Test
    void 서로_다른_세자리_숫자_생성_성공() {
        String baseballNumber = Baseball.generateNumber();
        Set<Character> list = baseballNumber.chars().mapToObj(i -> (char) i).collect(Collectors.toSet());

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(3, baseballNumber.length());
    }

    @Test
    void 서로_다른_세자리_숫자_생성_실패() {
        String baseballNumber = Baseball.generateNumber();
        Set<Character> list = baseballNumber.chars().mapToObj(i -> (char) i).collect(Collectors.toSet());

        Assertions.assertNotEquals(4, list.size());
        Assertions.assertNotEquals(4, baseballNumber.length());
    }
}