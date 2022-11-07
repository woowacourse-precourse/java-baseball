package baseball.system;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game = new Game();

    @Test
    void 스트라이크인지_볼인지_판별하는_기능_테스트() {
        List<Integer> problem = List.of(1,2,3);
        String answer = "321";

        game.isStrikeOrBall(problem, answer);
        List<Integer> result = List.of(game.getStrikeCnt(), game.getBallCnt());

        assertThat(result).isEqualTo(List.of(1,2));
    }

    @Test
    void 플레이어가_정답을_맞추었는지_판별하는_기능_ture_반환_테스트() {
        List<Integer> problem = List.of(1,2,3);
        String answer = "123";

        game.isStrikeOrBall(problem, answer);

        assertThat(game.correct()).isEqualTo(true);
    }

    @Test
    void 플레이어가_정답을_맞추었는지_판별하는_기능_false_반환_테스트() {
        List<Integer> problem = List.of(1,2,3);
        String answer = "312";

        game.isStrikeOrBall(problem, answer);

        assertThat(game.correct()).isEqualTo(false);
    }
}