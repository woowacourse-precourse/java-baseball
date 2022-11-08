package baseball.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user;

    @BeforeEach
    public void setUser() {
        user = new User();
    }

    @Test
    void selectBalls_숫자가_아닌_문자를_입력한_경우_예외_발생() {
        String input = "abc";

        input(input);

        assertThatThrownBy(() -> user.selectBalls())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void selectBalls_공을_3개_보다_많이_고른_경우_예외_발생() {
        String input = "1234";

        input(input);

        assertThatThrownBy(() -> user.selectBalls())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void selectBalls_공을_3개_보다_적게_고른_경우_예외_발생() {
        String input = "12";

        input(input);

        assertThatThrownBy(() -> user.selectBalls())
            .isInstanceOf(IllegalArgumentException.class);
    }

    private void input(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}