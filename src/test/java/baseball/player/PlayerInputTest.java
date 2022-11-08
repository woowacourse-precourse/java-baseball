package baseball.player;

import baseball.Application;
import baseball.utils.appConfig.AppConfig;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerInputTest extends NsTest {

    PlayerInput playerInput = AppConfig.createPlayerInput();

    @Test
    void 사용자_정상_입력시_리스트_형태로_저장() {
        playerInput.setNumbers("123");
        String numbers = playerInput.getNumbers().toString();

        assertThat(numbers).isEqualTo("[1, 2, 3]");
    }


    @Test
    void 사용자_입력이_서로_다른_수로_이루어지지_않은_경우_예외() {
        assertThatThrownBy(() -> playerInput.setNumbers("122"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_입력이_1부터_9사이의_숫자로_이루어지지_않은_경우_예외() {
        assertThatThrownBy(() -> playerInput.setNumbers("109"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_입력이_숫자로_이루어지지_않은_경우_예외() {
        assertThatThrownBy(() -> playerInput.setNumbers("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_3자리_이상_입력시_예외() {
        assertThatThrownBy(() -> playerInput.setNumbers("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임종료_후_새로시작_종료가_아닌_잘못된_값_문자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        assertRandomNumberInRangeTest(() -> {
                                    run("246", "135", "a");
                                    assertThat(output()).contains("낫싱", "3스트라이크");
                                },
                                1, 3, 5
                        ))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임종료_후_새로시작_종료가_아닌_잘못된_숫자_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        assertRandomNumberInRangeTest(() -> {
                                    run("246", "135", "4");
                                    assertThat(output()).contains("낫싱", "3스트라이크");
                                },
                                1, 3, 5
                        ))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}