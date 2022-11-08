package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @Test
    void 올바른_생성_확인() {
        for (int i = 0; i < 100; i++) {
            Computer.create();
        }
    }

    @Test
    void status_확인_1() {
        Computer test = Computer.of(1, 2, 3);
        User user = new User();
        user.guess = Numbers.of(1, 4, 2);
        String result = "1볼 1스트라이크";
        assertThat(result).isEqualTo(test.status(user).toString());
    }

    @Test
    void status_확인_2() {
        Computer test = Computer.of(1, 2, 3);
        User user = new User();
        user.guess = Numbers.of(4, 5, 6);
        String result = "낫싱";
        assertThat(result).isEqualTo(test.status(user).toString());
    }

    @Test
    void status_확인_3() {
        Computer test = Computer.of(1, 2, 3);
        User user = new User();
        user.guess = Numbers.of(1, 5, 6);
        String result = "1스트라이크";
        assertThat(result).isEqualTo(test.status(user).toString());
    }

    @Test
    void status_확인_4() {
        Computer test = Computer.of(1, 2, 3);
        User user = new User();
        user.guess = Numbers.of(2, 3, 1);
        String result = "3볼";
        assertThat(result).isEqualTo(test.status(user).toString());
    }
}
