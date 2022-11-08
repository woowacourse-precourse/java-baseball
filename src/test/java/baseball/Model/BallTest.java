package baseball.Model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BallTest {

    private static Ball ball;

    @BeforeAll
    static void setUp() {
        ball = new Ball();
    }

    @Test
    void ballHintpush_입력값의_따른_공의_힌트_해쉬맵에_넣기() {
        ball.setBallMap();
        ball.ballHintPush("123", "321");
        assertThat(ball.ballMap)
                .isNotEmpty()
                .containsKeys("볼", "스트라이크", "낫싱")
                .contains(entry("볼", 2))
                .contains(entry("스트라이크", 1));
    }

    @Test
    void returnHint_힌트의_결과_반환() {
        ball.setBallMap();
        ball.ballHintPush("123", "321");
        assertThat(ball.returnHint())
                .contains("2볼 1스트라이크");
    }
}