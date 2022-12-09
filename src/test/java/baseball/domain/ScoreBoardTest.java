package baseball.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ScoreBoardTest {

    @Nested
    class ScoreBoard의_인자값에_대해 {

        @Test
        void ball이_0이상_4이하가_아니면_예외() {
            assertThatThrownBy(() -> {
                new ScoreBoard(5, 0);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void strike가_0이상_3이하가_아니면_예외() {
            assertThatThrownBy(() -> {
                new ScoreBoard(0, 4);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class toScoreMessage_메소드는_메시지_형태의_문자열을_반환한다 {
        @ParameterizedTest(name = "{0}볼 {1}스트라이크인 경우")
        @CsvSource(value = {"1:1", "2:1", "3:2", "0:1"}, delimiter = ':')
        void parameterized_toString_test(int ball, int strike) {
            ScoreBoard scoreBoard = new ScoreBoard(ball, strike);

            List<String> resultMessage = new ArrayList<>();
            if (ball != 0) {
                resultMessage.add(ball + "볼");
            }
            if (strike != 0) {
                resultMessage.add(strike + "스트라이크");
            }

            assertThat(scoreBoard.toScoreMessage()).contains(resultMessage);
        }

        @Test
        void 점수가_0볼_0스트라이크인_경우_낫싱을_반환한다() {
            ScoreBoard scoreBoard = new ScoreBoard(0, 0);
            assertThat(scoreBoard.toScoreMessage()).isEqualTo("낫싱");
        }
    }

    @Test
    void equals_메소드에_ScoreBoard가_아닌_다른객체가_들어오면_거짓이다() {
        ScoreBoard scoreBoardA = new ScoreBoard(1, 2);
        Integer integer = 2;
        assertThat(scoreBoardA.equals(integer)).isFalse();
    }

    @Test
    void equals_메소드는_각각의_strike와_ball의_값이_모두_같으면_참이다() {
        ScoreBoard scoreBoardA = new ScoreBoard(1, 2);
        ScoreBoard scoreBoardB = new ScoreBoard(1, 2);

        assertThat(scoreBoardA.equals(scoreBoardB)).isTrue();
    }

    @Test
    void equals_메소드는_각각의_strike와_ball의_값이_하나라도_다르면_거짓이다() {
        ScoreBoard scoreBoardA = new ScoreBoard(1, 2);
        ScoreBoard scoreBoardB = new ScoreBoard(2, 2);

        assertThat(scoreBoardA.equals(scoreBoardB)).isFalse();
    }
}