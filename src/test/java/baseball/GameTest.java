package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    private static Game game;

    @BeforeAll
    static void setup(){
        game = new Game();
    }

    @Test
    void 유저인풋에는_숫자만_있어야함() {
        //given
        String input = "A23";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when then
        assertThatThrownBy(() -> game.start())
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(GameMessage.ILLEGAL_ARGUMENT_GUESS_NUMBER_FORMAT.message());
    }

    @Test
    void 유저인풋_범위는_1이상_9이하() {
        //given
        String input = "023";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when then
        assertThatThrownBy(() -> game.start())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(GameMessage.ILLEGAL_ARGUMENT_GUESS_RANGE.message());
    }

    @Test
    void 유저인풋_길이는_3() {
        //given
        String input = "12";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when then
        assertThatThrownBy(() -> game.start())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(GameMessage.ILLEGAL_ARGUMENT_GUESS_SIZE.message());
    }

    @Test
    void 유저인풋_중복_없어야함() {
        //given
        String input = "112";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when then
        assertThatThrownBy(() -> game.start())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(GameMessage.ILLEGAL_ARGUMENT_GUESS_DUPLICATE.message());
    }
}