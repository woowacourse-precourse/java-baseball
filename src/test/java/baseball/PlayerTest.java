package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    void askNumbers_유저가_입력한_값을_검증하고_반환한다() {
        TestablePlayer player = new TestablePlayer();
        List<Integer> userAnswer = player.askNumbers("123");
        assertThat(userAnswer).contains(1, 2, 3);
    }

    @Test
    void askNumbers_유저가_세자리_이상_입력하면_예외를_발생시킨다() {
        TestablePlayer player = new TestablePlayer();
        assertThatThrownBy(()-> player.askNumbers("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void askNumbers_유저가_세자리_이하_입력하면_예외를_발생시킨다() {
        TestablePlayer player = new TestablePlayer();
        assertThatThrownBy(()-> player.askNumbers("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void askNumbers_유저가_숫자가_아닌_문자를_입력하면_예외를_발생시킨다() {
        TestablePlayer player = new TestablePlayer();
        assertThatThrownBy(()-> player.askNumbers("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private class TestablePlayer extends Player {

        public List<Integer> askNumbers(String userAnswer) {
            return this.parseUserNumbersToList(userAnswer);
        }
    }
}
