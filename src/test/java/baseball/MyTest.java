package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyTest extends NsTest{

    @Test
    void 게임초기화_난수_생성() {
        // given
        GameContext gameCtx = new GameContext();
        // when
        gameCtx.initializeContext();
        Integer answer = Integer.parseInt(gameCtx.getAnswer());
        // then
        assertThat(answer).isGreaterThanOrEqualTo(111);
        assertThat(answer).isLessThanOrEqualTo(999);
        assertThat(gameCtx.getState()).isEqualTo(GameState.RUNNING);
    }

    @Test
    void 잘못된_값_입력에_대해_예외_발생() {
        // given
        GameContext gameCtx = new GameContext();
        gameCtx.initializeContext();
        // when
        String[] invalidInputs = {"12345", "101", "a8c", "1@1asd"};
        inputNumbersIntoStdin(invalidInputs);
        // then
        for (String input : invalidInputs)
            assertThatThrownBy(() -> gameCtx.handleUserInput())
                    .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 볼카운트_출력() {
        //given
        GameContext gameCtx = new GameContext();
        // when
        String[] inputs = {"246", "153", "513", "135"};
        // then
        inputNumbersIntoStdin(inputs);
        assertRandomNumberInRangeTest(
                () -> {
                    gameCtx.initializeContext();
                    inputNumbersIntoStdin(inputs);
                    for (String input : inputs)
                        gameCtx.handleUserInput();
                    assertThat(output().split("\n")).contains("낫싱", "2볼 1스트라이크", "3볼", "3스트라이크");
                    assertThat(gameCtx.getState()).isEqualTo(GameState.THREE_STRIKE);
                },
                1, 3, 5
        );

    }

    private void inputNumbersIntoStdin(String[] numbers) {
        final byte[] buf = String.join("\n", numbers).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
