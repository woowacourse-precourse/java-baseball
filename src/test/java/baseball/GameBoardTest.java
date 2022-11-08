package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameBoardTest extends NsTest {

    GameBoard gameBoard = new GameBoard();

    @Test
    void case1_랜덤값_확인() {
        try {
            Field result = gameBoard.getClass().getDeclaredField("randomNumbers");
            result.setAccessible(true);
            assertThat(gameBoard.createRandomNumbers()).isEqualTo(result.get(gameBoard));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void case2_비교_후_볼카운트_출력_확인() {
        assertRandomNumberInRangeTest(() -> {
            run("213", "123", "2");
            assertThat(output()).contains("2볼 1스트라이크", "3스트라이크", "게임 종료");
        }, 1, 2, 3);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
