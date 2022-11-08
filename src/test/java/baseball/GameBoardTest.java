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

    @Test
    void case3_기록_없는_경우_RECORDS_명령어_출력_확인() {
        assertRandomNumberInRangeTest(() -> {
            run("records","123","2");
            assertThat(output()).contains("입력된 정보가 없습니다.", "3스트라이크", "게임 종료");
        }, 1, 2, 3);
    }

    @Test
    void case4_기록_있는_경우_RECORDS_명령어_출력_확인() {
        assertRandomNumberInRangeTest(() -> {
            run("213", "records", "123", "2");
            assertThat(output()).contains("2볼 1스트라이크","현재 입력한 결과입니다.\r\n213 : 2볼 1스트라이크",
                    "3스트라이크", "게임 종료");
        }, 1, 2, 3);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
