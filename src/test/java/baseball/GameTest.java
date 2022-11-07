package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GameTest {
    Game game = new Game();

    @Test
    void 랜덤_넘버_생성() {
        List<Integer> list1 = game.makeRandomNumber();
        List<Integer> list2 = game.makeRandomNumber();
        Assertions.assertThat(list1).isNotSameAs(list2);
    }
}