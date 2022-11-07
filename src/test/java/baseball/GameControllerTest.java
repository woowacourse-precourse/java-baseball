package baseball;

import baseball.gameController.GameController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameControllerTest {
    private GameController gameController;

    public GameControllerTest(){
        gameController = new GameController();
    }

    @Test
    void 유저의_숫자와_정답을_비교한_후_볼_스트라이크_개수_확인(){
        assertThat(gameController.countStrikeBall("123", "213")).isEqualTo(new int[]{2,1});
        assertThat(gameController.countStrikeBall("456", "789")).isEqualTo(new int[]{0,0});
        assertThat(gameController.countStrikeBall("159", "915")).isEqualTo(new int[]{3,0});
        assertThat(gameController.countStrikeBall("534", "534")).isEqualTo(new int[]{0,3});
        assertThat(gameController.countStrikeBall("159", "148")).isEqualTo(new int[]{0,1});
        assertThat(gameController.countStrikeBall("159", "175")).isEqualTo(new int[]{1,1});
        assertThat(gameController.countStrikeBall("159", "139")).isEqualTo(new int[]{0,2});
    }

    @Test
    void ThreeStrike_체크함수_확인(){
        assertThat(gameController.isThreeStrike("123", "213")).isEqualTo(false);
        assertThat(gameController.isThreeStrike("456", "789")).isEqualTo(false);
        assertThat(gameController.isThreeStrike("159", "915")).isEqualTo(false);
        assertThat(gameController.isThreeStrike("534", "534")).isEqualTo(true);
        assertThat(gameController.isThreeStrike("159", "148")).isEqualTo(false);
        assertThat(gameController.isThreeStrike("159", "175")).isEqualTo(false);
        assertThat(gameController.isThreeStrike("159", "139")).isEqualTo(false);
    }
}
