package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    @Test
    void testGetHint_1() {
        Computer computer = new Computer("234");
        String hint = computer.getHint("345");
        assertThat(hint).isEqualTo("2볼");
    }

    @Test
    void testGetHint_2() {
        Computer computer = new Computer("189");
        String hint = computer.getHint("345");
        assertThat(hint).isEqualTo("낫싱");
    }

    @Test
    void testGetHint_3() {
        Computer computer = new Computer("189");
        String hint = computer.getHint("123");
        assertThat(hint).isEqualTo("1스트라이크");
    }

    @Test
    void testGetHint_4() {
        Computer computer = new Computer("713");
        String hint = computer.getHint("123");
        assertThat(hint).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void testGetHint_5() {
        Computer computer = new Computer("713");
        String hint = computer.getHint("145");
        assertThat(hint).isEqualTo("1볼");
    }

    @Test
    void testGetHint_6() {
        Computer computer = new Computer("713");
        String hint = computer.getHint("671");
        assertThat(hint).isEqualTo("2볼");
    }

    @Test
    void testGetHint_7() {
        Computer computer = new Computer("713");
        String hint = computer.getHint("216");
        assertThat(hint).isEqualTo("1스트라이크");
    }

}
