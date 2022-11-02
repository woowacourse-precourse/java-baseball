package baseball.inputs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameInputOutputTest {

    GameInputOutput checkInput = new GameInputOutput();

    @Test
    void haveSameNumbers_case1() {
        String input = "123";
        boolean output = true;
        assertThat(checkInput.haveSameNumbers(input)).isEqualTo(output);
    }

    @Test
    void haveSameNumbers_case2() {
        String input = "122";
        boolean output = false;
        assertThat(checkInput.haveSameNumbers(input)).isEqualTo(output);
    }

    @Test
    void haveSameNumbers_case3() {
        String input = "313";
        boolean output = false;
        assertThat(checkInput.haveSameNumbers(input)).isEqualTo(output);
    }
}