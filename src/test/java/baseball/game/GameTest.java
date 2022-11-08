package baseball.game;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class GameTest extends NsTest {

    Game game;

    @BeforeEach
    void 초기화() {
        game = Game.create();
    }

    @Test
    void 게임시작시_시작메세지가_출력되어야한다() {
        assertSimpleTest(
                () -> {
                    assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
                }
        );
    }

    @Test
    void 사용자가_잘못된_입력을_할_경우_예외_처리_해야한다() {
        assertThatThrownBy(() -> game.inputCheck("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 입력만 가능합니다.");

        assertThatThrownBy(() -> game.inputCheck("000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9까지의 숫자만 입력이 가능합니다.");

        assertThatThrownBy(() -> game.inputCheck("b2a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9까지의 숫자만 입력이 가능합니다.");

        assertThatThrownBy(() -> game.inputCheck("112"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 수만 입력이 가능합니다.");

    }

    @Test
    void 볼_스트라이크_개수를_가져와야_한다() {
        assertThat(
                game.getBallStrikeCount(Arrays.asList(1, 2, 3), Arrays.asList(2, 4, 3))
                        .equals(Map.of(
                                "볼", 1,
                                "스트라이크", 1
                        )));
        assertThat(
                game.getBallStrikeCount(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3))
                        .equals(Map.of(
                                "볼", 0,
                                "스트라이크", 3
                        )));
        assertThat(
                game.getBallStrikeCount(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2))
                        .equals(Map.of(
                                "볼", 3,
                                "스트라이크", 0
                        )));
    }

    @Test
    void 볼과_스트라이크의_개수가_나와야_한다() {
        assertSimpleTest(() -> {
            game.printGameResult(Map.of(
                    "볼", 1,
                    "스트라이크", 2
            ));
            assertThat(output()).contains("1볼 2스트라이크");
        });
    }

    @Test
    void 스트라이크만_3이_나와야_한다() {
        assertSimpleTest(() -> {
            game.printGameResult(Map.of(
                    "볼", 0,
                    "스트라이크", 3
            ));
            assertThat(output()).contains("3스트라이크");
        });
    }

    @Test
    void 볼만_3이_나와야_한다() {
        assertSimpleTest(() -> {
            game.printGameResult(Map.of(
                    "볼", 3,
                    "스트라이크", 0
            ));
            assertThat(output()).contains("3볼");
        });
    }

    @Test
    void 낫싱이_나와야_한다() {
        assertSimpleTest(() -> {
            game.printGameResult(Map.of(
                    "볼", 0,
                    "스트라이크", 0
            ));
            assertThat(output()).contains("낫싱");
        });
    }

    @Test
    void 스트라이가_3이_아니면_false가_나와야_한다() {
        assertThat(game.isGameEnd(Map.of(
                "볼", 2,
                "스트라이크", 1
        ))).isFalse();
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
