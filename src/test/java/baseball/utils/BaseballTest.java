package baseball.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BaseballTest {

    @Test
    void getBaseballNumberTest() {
        String input = "123";
        Baseball player = Baseball.createPlayer(input);

        assertThat(player.getBaseballNumber()).isEqualTo(Arrays.asList(1,2,3));
    }

    @Test
    void createComputerTest() {
        Baseball computer = Baseball.createComputer();
        List<Integer> computerBaseballNumber = computer.getBaseballNumber();

        assertThat(computerBaseballNumber.size()).isEqualTo(3);
    }

    @Test
    void createPlayerTest() {
        String input1 = "123";
        String input2 = "1234";
        String input3 = "1233";
        String input4 = "12";

        assertThat(Baseball.class).isEqualTo(Baseball.createPlayer(input1).getClass());

        assertThatThrownBy(() -> Baseball.createPlayer(input2))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Baseball.createPlayer(input3))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Baseball.createPlayer(input4))
                .isInstanceOf(IllegalArgumentException.class);

    }
}