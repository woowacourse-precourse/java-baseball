package baseball.game;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class GameTest extends NsTest {

    Game game;

    @BeforeEach
    void setUp() {
        game = Game.create(new Computer(), new User());
    }

    @Test
    void 게임시작시_시작메세지가_출력돼야한다() {
        assertSimpleTest(() ->
                assertThat(output().contains("숫자 야구 게임을 시작합니다."))
                        .isTrue()
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}