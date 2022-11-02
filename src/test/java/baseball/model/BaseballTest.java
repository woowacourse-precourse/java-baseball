package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseballTest {

    private final String BASEBALL_NUMBER = Baseball.generateNumber();

    @Test
    void 서로_다른_세자리_숫자_생성_성공() {
        Set<Character> list = BASEBALL_NUMBER.chars().mapToObj(i -> (char) i).collect(Collectors.toSet());

        assertEquals(3, list.size());
        assertEquals(3, BASEBALL_NUMBER.length());
    }
}