package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GenerateTest {

    @Test
    void radomNumber_랜덤_숫자_길이_확인() {
        int input = 3;

        assertThat(Generate.randomNumber().size()).isEqualTo(input);
    }
}
