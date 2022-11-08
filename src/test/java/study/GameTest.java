package study;

import baseball.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void getScore() {
        List<Integer> answer = Arrays.asList(1, 2, 3);
        String guess = "328";
        int[] result = {1, 1};
        assertThat(Game.getScore(answer, guess)).isEqualTo(result);
    }


    @Test
    void checkNumber() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class
                , () -> Game.checkNumber("902"));
        assertThat(e.getMessage()).isEqualTo("1부터 9까지의 수를 입력하세요");
    }

}