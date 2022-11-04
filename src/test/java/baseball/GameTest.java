package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class GameTest {

    @Test
    void 게임_시작_문구_출력() {
        String openingPhrase = "숫자 야구 게임을 시작합니다.";
        Game game = new Game();
        assertThat(openingPhrase).isEqualTo(game.opening());
    }

}