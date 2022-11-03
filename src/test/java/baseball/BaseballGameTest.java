package baseball;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    @Test
    void 랜덤한_3개의_숫자_리스트_생성() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // when
        List<Integer> list = baseballGame.getRandomNumberList();

        // then
        Assertions.assertThat(list.size()).isEqualTo(3);
    }
}
