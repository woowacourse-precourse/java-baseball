package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class HintTest {

    @Test
    void 힌트가_0볼_0스트라이크인경우_낫싱() {
        Hint hint = Hint.builder().strike(0).ball(0).build();
        assertThat(hint.toString()).isEqualTo("낫싱");
    }

    @Test
    void 힌트가_0볼_n스트라이크인경우_n스트라이크() {
        Hint hint1 = Hint.builder().strike(2).build();
        assertThat(hint1.toString()).isEqualTo("2스트라이크");

        Hint hint2 = Hint.builder().strike(3).build();
        assertThat(hint2.toString()).isEqualTo("3스트라이크");
    }

    @Test
    void 힌트가_n볼_0스트라이크인경우_n볼() {
        Hint hint1 = Hint.builder().ball(2).build();
        assertThat(hint1.toString()).isEqualTo("2볼");

        Hint hint2 = Hint.builder().ball(3).build();
        assertThat(hint2.toString()).isEqualTo("3볼");
    }

    @Test
    void 힌트가_n볼_m스트라이크인경우_n볼_m스트라이크() {
        Hint hint1 = Hint.builder().strike(1).ball(1).build();
        assertThat(hint1.toString()).isEqualTo("1볼 1스트라이크");

        Hint hint2 = Hint.builder().strike(1).ball(2).build();
        assertThat(hint2.toString()).isEqualTo("2볼 1스트라이크");
    }
}
