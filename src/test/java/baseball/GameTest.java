package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    @Test
    void 컴퓨터가_생성한_숫자_조건체크(){
        Game game = new Game();
        List<Integer> result = game.createComputerNumber();

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0) != result.get(1)).isEqualTo(true);
        assertThat(result.get(0) != result.get(2)).isEqualTo(true);
        assertThat(result.get(1) != result.get(2)).isEqualTo(true);
    }

}