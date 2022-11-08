package baseball.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static baseball.values.Constant.Exception.INPUTTED_NUMBER_CNT;
import static baseball.values.Constant.Exception.SAME_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BaseballTest {

    @Test
    void getBaseballNumberTest() {
        String input = "123";
        Baseball player = Baseball.createPlayer(input);

        assertThat(player.getBaseballNumber()).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void createComputerTest() {
        Baseball computer = Baseball.createComputer();
        List<Integer> computerBaseballNumber = computer.getBaseballNumber();

        assertThat(computerBaseballNumber.size()).isEqualTo(3);
    }

    @Test
    void createPlayerTest() {
        String input = "123";

        assertThat(Baseball.class).isEqualTo(Baseball.createPlayer(input).getClass());
    }

    @Test
    void validateSameNumberTest() {
        String input = "122";

        assertThatThrownBy(() -> Baseball.createPlayer(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SAME_NUMBER);


    }

    @Test
    void validateInputNumberCntTest() {
        String input1 = "1234";
        String input2 = "12";

        assertThatThrownBy(() -> Baseball.createPlayer(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUTTED_NUMBER_CNT);


        assertThatThrownBy(() -> Baseball.createPlayer(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUTTED_NUMBER_CNT);
    }
}