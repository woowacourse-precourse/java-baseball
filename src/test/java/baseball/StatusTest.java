package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StatusTest {

    @Test
    void correct_확인_1() {
        Computer test = Computer.of(1, 2, 3);
        User user = new User();
        user.guess = Numbers.of(1, 2, 3);
        assertThat(test.status(user).correct()).isTrue();
    }

    @Test
    void correct_확인_2() {
        Computer test = Computer.of(1, 2, 3);
        User user = new User();
        user.guess = Numbers.of(1, 2, 4);
        assertThat(test.status(user).correct()).isFalse();
    }
}
