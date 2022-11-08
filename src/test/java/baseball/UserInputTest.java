package baseball;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputTest {
    @Test
    void generatePlayerBalls_길이_예외_테스트() {
        //given
        List<Integer> playerValues = List.of(1, 2, 3, 4);
        //when
        //then
        assertThatThrownBy(() -> {
           User user = new User(playerValues);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generatePlayerBalls_중복_예외_테스트() {
        //given
        List<Integer> playerValues = List.of(1, 2, 2);
        //when
        //then
        assertThatThrownBy(() -> {
            User user = new User(playerValues);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generatePlayerBalls_input_status_테스트() {
        //given
        String input = "3";
        //when
        //then
        assertThatThrownBy(() -> {
            User.checkStatusInput(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
