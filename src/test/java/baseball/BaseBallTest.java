package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;


class BaseBallTest {

    private final BaseBall baseBall = new BaseBall();

    @Test
    public void userBall이_3개의_수를_가지는지_확인() {
        String input = "123";
        baseBall.readNumber(input);

        assertThat(baseBall.getUserBall()).hasSize(3);
    }

    @Test
    public void userBall과_input이_같은값을_가지는지_확인() {
        String input = "123";
        baseBall.readNumber(input);

        Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .forEach(number -> assertThat(baseBall.getUserBall()).contains(number));
    }

}