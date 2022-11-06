package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputValidCheckerImpTest {

    InputValidChecker inputValidChecker;

    @BeforeEach
    public void beforeEach() {
        inputValidChecker = new InputValidCheckerImp();
    }

    @Test
    void 사용자입력은_1부터_9로만_이루어져야함() {
        // given
        List<Integer> user1 = List.of(1, 2, 3);
        List<Integer> user2 = List.of(-1, 2, 3);
        List<Integer> user3 = List.of(0, 2, 3);
        List<Integer> user4 = List.of(1, 2, 10);

        // when
        boolean result1 = inputValidChecker.checkValid(user1);
        boolean result2 = inputValidChecker.checkValid(user2);
        boolean result3 = inputValidChecker.checkValid(user3);
        boolean result4 = inputValidChecker.checkValid(user4);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
    }

    @Test
    void 사용자입력은_세자리여야함() {
        // given
        List<Integer> user1 = List.of(1, 2, 3);
        List<Integer> user2 = List.of();
        List<Integer> user3 = List.of(1, 2, 3, 4);
        List<Integer> user4 = List.of(1, 2);

        // when
        boolean result1 = inputValidChecker.checkValid(user1);
        boolean result2 = inputValidChecker.checkValid(user2);
        boolean result3 = inputValidChecker.checkValid(user3);
        boolean result4 = inputValidChecker.checkValid(user4);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
    }

    @Test
    void 사용자입력은_서로_다른_수로만_이루어져야함() {
        List<Integer> user1 = List.of(1, 2, 3);
        List<Integer> user2 = List.of(1, 1, 1);
        List<Integer> user3 = List.of(1, 1, 2);
        List<Integer> user4 = List.of(2, 1, 1);

        // when
        boolean result1 = inputValidChecker.checkValid(user1);
        boolean result2 = inputValidChecker.checkValid(user2);
        boolean result3 = inputValidChecker.checkValid(user3);
        boolean result4 = inputValidChecker.checkValid(user4);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
    }
}
