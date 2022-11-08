package baseball.components;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    @DisplayName("점수 생성 테스트")
    void generateScoreTest(){
        int ballCount = 0;
        int strikeCount = 2;
        Score score = new Score(ballCount, strikeCount);

        assertAll(
                () -> assertThat(score.getBall()).isEqualTo(ballCount),
                () -> assertThat(score.getStrike()).isEqualTo(strikeCount)
        );

    }

    @Nested
    class ToStringTest {

        @Test
        @DisplayName("toString - 낫싱")
        void toStringNotingTest(){
            Score score = new Score(0, 0);

            assertThat(score.toString()).isEqualTo("낫싱");
        }

        @Test
        @DisplayName("toString - 2볼")
        void toStringBallTest(){
            Score score = new Score(2, 0);

            assertThat(score.toString()).isEqualTo("2볼");
        }

        @Test
        @DisplayName("toString - 2볼 1스트라이크")
        void toStringBallStrikeTest(){
            Score score = new Score(2, 1);

            assertThat(score.toString()).isEqualTo("2볼 1스트라이크");
        }

    }



}