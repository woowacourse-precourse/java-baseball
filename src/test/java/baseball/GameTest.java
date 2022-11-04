package baseball;

import baseball.utils.GameUtil;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Game 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameTest extends NsTest {
    private final int computerNumber = 123;

    @Test
    void 게임_플레이() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("987", "198", "918", "132", "123");
                    assertThat(output()).contains("낫싱", "1스트라이크", "1볼", "2볼 1스트라이크", "3스트라이크");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Override
    protected void runMain() {
        Game game = new Game(this.computerNumber);
        game.run(GameUtil.splitNumberToOneDigitNumbers(this.computerNumber).size());
    }
}
