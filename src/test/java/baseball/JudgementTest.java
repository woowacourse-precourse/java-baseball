package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class JudgementTest {
    Judge judge = new Judge();
    List<Integer> answer = List.of(7, 9, 1);

    @Test
    void 낫싱_판정 () {
        String result = judge.judgement(answer, List.of(3, 6, 8));
        assertSame("낫싱", result);

        result = judge.judgement(answer, List.of(5, 4, 3));
        assertSame("낫싱", result);
    }

    @Test
    void 볼_판정 () {
        String result = judge.judgement(answer, List.of(1, 2, 3));
        assertEquals("1볼", result);

        result = judge.judgement(answer, List.of(9, 7, 2));
        assertEquals("2볼", result);

        result = judge.judgement(answer, List.of(1, 7, 9));
        assertEquals("3볼", result);
    }

    @Test
    void 스트라이크_판정 () {
        String result = judge.judgement(answer, List.of(7, 2, 3));
        assertEquals("1스트라이크", result);

        result = judge.judgement(answer, List.of(7, 9, 3));
        assertEquals("2스트라이크", result);

        result = judge.judgement(answer, List.of(7, 9, 1));
        assertEquals("3스트라이크", result);
    }

    @Test
    void 볼_스트라이크_판정 () {
        String result = judge.judgement(answer, List.of(1, 9, 7));
        assertEquals("2볼 1스트라이크", result);

        result = judge.judgement(answer, List.of(3, 9, 7));
        assertEquals("1볼 1스트라이크", result);
    }
}
