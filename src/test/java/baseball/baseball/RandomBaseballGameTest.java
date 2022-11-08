package baseball.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBaseballGameTest {

    @Test
    @DisplayName("랜덤 Digits과 입력된 Digits이 매칭 되는지 확인")
    void match() {
        // given
        BaseballGame baseballGame = new BaseballGame();
        RandomBaseballGame randomBaseballGame = new RandomBaseballGame(baseballGame);

        Digits playerDigits = new Digits(List.of(2, 3, 4));
        randomBaseballGame.newGame(new Digits(List.of(2, 3, 4)));

        // when
        Result result = randomBaseballGame.match(playerDigits);

        // then
        assertThat(result).isEqualTo(new Result(3, 0));
    }
}