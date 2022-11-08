package baseball;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ScoreTest {

    @Test
    void 올_스트라이크_비교_테스트() {

        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 3);

        Score score = new Score(3);
        score.updateTotalScore(computer, user);
        assertEquals(score, new Score(3, 3, 0, 0));
    }

    @Test
    void 올_볼_비교_테스트() {

        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(3, 1, 2);

        Score score = new Score(3);
        score.updateTotalScore(computer, user);
        assertEquals(score, new Score(3, 0, 3, 0));
    }

    @Test
    void 기타_비교_테스트() {

        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 5, 4);

        Score score = new Score(3);
        score.updateTotalScore(computer, user);
        assertEquals(score, new Score(3, 1, 0, 2));
    }


}