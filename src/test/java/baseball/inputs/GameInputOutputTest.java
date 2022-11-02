package baseball.inputs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameInputTest {

    GameInput checkInput = new GameInput();

    @Test
    void computerMadeNumbers(){
        List<Integer> computerMadeNumbers = checkInput.computerMadeNumbers();
        int outputLength = 3;
        assertThat(computerMadeNumbers.size()).isEqualTo(outputLength);
    }

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