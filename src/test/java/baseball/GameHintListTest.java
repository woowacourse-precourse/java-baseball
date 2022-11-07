package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameHintListTest {

    @Test
    void printGameHintList() {
    }

    @Test
    void countOfStrike() {
    }

    @Test
    void countOfBall() {
    }

    @Test
    @DisplayName("입력한 수가 컴퓨터의 수와 하나도 일치하지 않으면 낫싱이 발생한다")
    void isNothingSame() {
        //given
        GameHintList gameHintList = new GameHintList();
        GameHintList.computerSelectedNumbers = new ArrayList<>(Arrays.asList("3", "6", "9"));
        GameHintList.userSelectedNumbers = new ArrayList<>(Arrays.asList("1", "2", "5"));

        //when
        boolean testIsNothingSame = gameHintList.isNothingSame();

        //then
        Assertions.assertThat(testIsNothingSame).isEqualTo(true);
    }

}