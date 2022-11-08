package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ScoreTest {
    private Score score;

    @BeforeEach
    public void setScore() {
        score = new Score(1, 2);
    }

    @DisplayName("길이는 2여야 한다")
    @Test
    void getScoreTest() {
        assertThat(score.getScore().size()).isEqualTo(2);
    }

    @DisplayName("ArrayList여야 한다")
    @Test
    void typeTest() {
        assertThat(score.getScore()).isInstanceOf(ArrayList.class);
    }

    @DisplayName("각 원소는 Integer여야 한다")
    @Test
    void elementTest() {
        assertThat(score.getScore())
                .allSatisfy(element -> {
                    assertThat(element).isInstanceOf(Integer.class);
                });
    }
}