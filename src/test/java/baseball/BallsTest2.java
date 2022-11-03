package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BallsTest2 {
    Balls computer;

    @BeforeEach
    void init() {
        computer = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void nothing() {

//        Assertions.assertThat(computer.play())
    }
}
