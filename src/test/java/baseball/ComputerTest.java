package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

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
        System.setIn(new ByteArrayInputStream("134".getBytes()));
        user.guess();
        String result = "1볼 1스트라이크";
        assertThat(result).isEqualTo(test.status(user).toString());
    }

    @Test
    void status_확인_2() {
        Computer test = Computer.of(1, 2, 3);
        User user = new User();
        System.setIn(new ByteArrayInputStream("456".getBytes()));
        user.guess();
        String result = "낫싱";
        assertThat(result).isEqualTo(test.status(user).toString());
    }

    @Test
    void status_확인_3() {
        Computer test = Computer.of(1, 2, 3);
        User user = new User();
        System.setIn(new ByteArrayInputStream("156".getBytes()));
        user.guess();
        String result = "1스트라이크";
        assertThat(result).isEqualTo(test.status(user).toString());
    }

    @Test
    void status_확인_4() {
        Computer test = Computer.of(1, 2, 3);
        User user = new User();
        System.setIn(new ByteArrayInputStream("231".getBytes()));
        user.guess();
        String result = "3볼";
        assertThat(result).isEqualTo(test.status(user).toString());
    }
}
