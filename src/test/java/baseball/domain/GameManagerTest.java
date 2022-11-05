package baseball.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


class GameManagerTest extends NsTest {

    @Test
    void run_메소드로_사용자입력에_따라_게임_재시작하거나_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("146", "1", "789", "2");
                    assertThat(output()).contains("게임 종료", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                },
                1,4,6,7,8,9
        );
    }

    @Override
    public void runMain() {
        GameManager manager = new GameManager();
        manager.run();
    }
}