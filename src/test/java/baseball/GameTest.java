package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {
    Game game = new Game();

    @Test
    void 랜덤_넘버_생성() {
        List<Integer> list1 = game.makeRandomNumber();
        List<Integer> list2 = game.makeRandomNumber();
        assertThat(list1).isNotSameAs(list2);
    }

    @Test
    void 사용자_입력_받기() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = game.input();
        assertThat(list1).isSameAs(list2);
    }
}