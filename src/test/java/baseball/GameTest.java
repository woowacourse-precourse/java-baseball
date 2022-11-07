package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GameTest {

    Game game;

    @BeforeEach
    void beforeEach() {
        game = new Game();
    }

    @Test
    void 스트라이크_3개인_경우_true반환() {
        //given
        String result = "3스트라이크";
        // when
        boolean strikeOut = game.isStrikeOut(result);
        // then
        assertThat(strikeOut).isTrue();
    }

    @Test
    void 스트라이크_3개가_아닌_경우_false반환() {
        //given
        String result = "1스트라이크";
        // when
        boolean strikeOut = game.isStrikeOut(result);
        // then
        assertThat(strikeOut).isFalse();
    }

}