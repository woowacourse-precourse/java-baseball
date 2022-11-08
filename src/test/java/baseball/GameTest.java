package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


public class GameTest extends NsTest {
    private static Game game;

    @BeforeAll
    static void initTest(){
        game = new Game();
    }

    @Test
    void 게임_작동_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run( "123", "2");
                    assertThat(output()).contains("숫자 야구 게임을 시작합니다.", "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                },
                1,2,3
        );
    }

    @Override
    public void runMain() {
        game.play();
    }
}
