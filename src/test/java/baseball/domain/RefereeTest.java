package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @Test
    void 스트라이크3_맞는지_확인() {
        String result = "3스트라이크";
        String judgment = referee.resultJudgment(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        assertThat(judgment).isEqualTo(result);
    }

    @Test
    void 스트라이크2_맞는지_확인() {
        String result = "2스트라이크";
        String judgment = referee.resultJudgment(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 7));
        assertThat(judgment).isEqualTo(result);
    }

    @Test
    void 스트라이크1_맞는지_확인() {
        String result = "1스트라이크";
        String judgment = referee.resultJudgment(Arrays.asList(1, 2, 3), Arrays.asList(1, 5, 7));
        assertThat(judgment).isEqualTo(result);
    }

    @Test
    void 볼3_맞는지_확인() {
        String result = "3볼";
        String judgment = referee.resultJudgment(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2));
        assertThat(judgment).isEqualTo(result);
    }

    @Test
    void 볼2_맞는지_확인() {
        String result = "2볼";
        String judgment = referee.resultJudgment(Arrays.asList(1, 2, 3), Arrays.asList(7, 3, 2));
        assertThat(judgment).isEqualTo(result);
    }

    @Test
    void 볼1_맞는지_확인() {
        String result = "1볼";
        String judgment = referee.resultJudgment(Arrays.asList(1, 2, 3), Arrays.asList(7, 6, 1));
        assertThat(judgment).isEqualTo(result);
    }

    @Test
    void 볼1_스트라이크1_맞는지_확인() {
        String result = "1볼 1스트라이크";
        String judgment = referee.resultJudgment(Arrays.asList(1, 2, 3), Arrays.asList(5, 1, 3));
        assertThat(judgment).isEqualTo(result);
    }

    @Test
    void 볼2_스트라이크1_맞는지_확인() {
        String result = "2볼 1스트라이크";
        String judgment = referee.resultJudgment(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2));
        assertThat(judgment).isEqualTo(result);
    }

    @Test
    void 낫싱_맞는지_확인() {
        String result = "낫싱";
        String judgment = referee.resultJudgment(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        assertThat(judgment).isEqualTo(result);
    }
}