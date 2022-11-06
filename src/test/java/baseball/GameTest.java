package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class GameTest {

    Game game;

    @BeforeEach
    void init() {
        game = new Game();
    }

    @Test
    @DisplayName("Computer 는 서로 다른 3개의 숫자를 만들 수 있다")
    void testComputerMakesThreeDifferentNumber() throws Exception {
        //given
        List<Integer> numberList = game.makesDifferenceThreeNumber();

        //when
        Set<Integer> numberSet = new HashSet<>(numberList);

        //then
        assertThat(numberSet.size()).isEqualTo(3);
    }
}