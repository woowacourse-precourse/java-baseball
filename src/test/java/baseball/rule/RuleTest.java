package baseball.rule;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RuleTest {
    private Rule rule;

    @BeforeEach
    void init() {
        rule = new Rule();
    }

    @Test
    void 규칙_테스트1() {
        // given
        List<Integer> user = List.of(1, 4, 3);
        List<Integer> computer = List.of(2, 7, 3);

        // when
        rule.check(user, computer);

        // then
        assertThat(rule.getBall()).isEqualTo(0);
        assertThat(rule.getStrike()).isEqualTo(1);
    }

    @Test
    void 규칙_테스트2() {
        // given
        List<Integer> user = List.of(7, 2, 3);
        List<Integer> computer = List.of(2, 7, 3);

        // when
        rule.check(user, computer);

        // then
        assertThat(rule.getBall()).isEqualTo(2);
        assertThat(rule.getStrike()).isEqualTo(1);
    }
}
