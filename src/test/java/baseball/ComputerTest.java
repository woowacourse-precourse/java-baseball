package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @Test
    void testGetHint() {
        Computer computer = new Computer("234");
        String hint = computer.getHint("345");
        assertThat(hint).isEqualTo("2볼");
    }

    @Test
    void getHintMessage_낫싱_반환() {
        Computer computer = new Computer("234", 0, 0);
        assertThat(computer.getHintMessage()).isEqualTo("낫싱");
    }

    @Test
    void getHintMessage_3스트라이크_반환() {
        Computer computer = new Computer("234", 0, 3);
        assertThat(computer.getHintMessage()).isEqualTo("3스트라이크");
    }

    @Test
    void getHintMessage_볼과스트라이크_반환() {
        Computer computer = new Computer("234", 1, 2);
        assertThat(computer.getHintMessage()).isEqualTo("1볼 2스트라이크");
    }
}
