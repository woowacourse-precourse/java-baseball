package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void 스트라이크_카운트_테스트(){
        Game game = new Game();
        List<Integer> computerNumeralList = Arrays.asList(1, 2, 4);
        List<Integer> userNumeralList = Arrays.asList(1, 2, 3);
        game.countStrike(computerNumeralList, userNumeralList);
        assertThat(game.getStrikeCount()).isEqualTo(2);
    }

    @Test
    public void 볼_카운트_테스트(){
        Game game = new Game();
        List<Integer> computerNumeralList = Arrays.asList(4, 1, 2);
        List<Integer> userNumeralList = Arrays.asList(1, 2, 4);
        game.countBall(computerNumeralList, userNumeralList);
        assertThat(game.getBallCount()).isEqualTo(3);
    }
}