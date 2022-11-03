package baseball;

import baseball.score.NStrikeNBallScore;
import baseball.score.NothingScore;
import baseball.score.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreCalculatorTest {
    ScoreCalculator scoreCalculator;

    @BeforeEach
    void setup() {
        scoreCalculator = new ScoreCalculator();
    }

    @Test
    void NothingTest() {
        assertThat(scoreCalculator.calculateScore(123, 567)).isInstanceOf(NothingScore.class);
    }

    @Test
    void OneStrikeTest() {
        Score expect = scoreCalculator.calculateScore(123, 145);
        assertThat(expect).isInstanceOf(NStrikeNBallScore.class);
        assertThat(expect.toString()).isEqualTo("1스트라이크");
    }

    @Test
    void TwoStrikeTest() {
        Score expect = scoreCalculator.calculateScore(123, 125);
        assertThat(expect).isInstanceOf(NStrikeNBallScore.class);
        assertThat(expect.toString()).isEqualTo("2스트라이크");
    }

    @Test
    void ThreeStrikeTest() {
        Score expect = scoreCalculator.calculateScore(123, 123);
        assertThat(expect).isInstanceOf(NStrikeNBallScore.class);
        assertThat(expect.toString()).isEqualTo("3스트라이크");
    }

    @Test
    void OneStrikeOneBallTest() {
        Score expect = scoreCalculator.calculateScore(123, 142);
        assertThat(expect).isInstanceOf(NStrikeNBallScore.class);
        assertThat(expect.toString()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void OneStrikeTwoBallTest() {
        Score expect = scoreCalculator.calculateScore(123, 132);
        assertThat(expect).isInstanceOf(NStrikeNBallScore.class);
        assertThat(expect.toString()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void ThreeBallTest() {
        Score expect = scoreCalculator.calculateScore(123, 312);
        assertThat(expect).isInstanceOf(NStrikeNBallScore.class);
        assertThat(expect.toString()).isEqualTo("3볼");
    }

    @Test
    void twoBallTest() {
        Score expect = scoreCalculator.calculateScore(123, 342);
        assertThat(expect).isInstanceOf(NStrikeNBallScore.class);
        assertThat(expect.toString()).isEqualTo("2볼");
    }

    @Test
    void oneBallTest() {
        Score expect = scoreCalculator.calculateScore(123, 354);
        assertThat(expect).isInstanceOf(NStrikeNBallScore.class);
        assertThat(expect.toString()).isEqualTo("1볼");
    }
}