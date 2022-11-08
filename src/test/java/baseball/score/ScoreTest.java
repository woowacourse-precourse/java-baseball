package baseball.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.score.ScoreStatus.STRIKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreTest {

    private Score score;

    @BeforeEach
    void setUp() {
        score = new Score(0, 0);
    }

    @Test
    @DisplayName("clear method test")
    void clearTest() {
        // given
        score = new Score(1, 1);

        // when
        score.clear();

        // then
        assertAll(
          () -> assertEquals(0, score.getStrike()),
          () -> assertEquals(0, score.getBall())
        );

    }

    @Test
    @DisplayName("strike ball 개수 세기 test")
    void countTotalScoreTest(){
        //given
        List<ScoreStatus> scoreStatusList =List.of(STRIKE,STRIKE);

        //when
        score.countTotalScore(scoreStatusList);

        //then
        assertAll(
                () -> assertEquals(2, score.getStrike()),
                () -> assertEquals(0, score.getBall())
        );
    }

}