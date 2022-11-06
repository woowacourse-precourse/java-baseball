package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("게임종료 후 재시작")
    void play_restart() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "1", "134", "1", "123", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9, 1, 3, 4, 1, 2, 3
        );
    }

    @Test
    @DisplayName("게임시작 후 종료")
    void play_exit() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "2");
                    assertThat(output()).contains("3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    @DisplayName("예외 테스트 진행간 잘못된 값 입력")
    void valid_wrong_input() {
        assertThatThrownBy(
                () -> assertRandomNumberInRangeTest(
                        () -> {
                            run("246", "1345", "1", "597", "589", "1", "134", "1", "123", "2");
                            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                        },
                        1, 3, 5, 5, 8, 9, 1, 3, 4, 1, 2, 3
                )
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> assertRandomNumberInRangeTest(
                        () -> {
                            run("246", "122", "1", "597", "589", "1", "134", "1", "123", "2");
                            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                        },
                        1, 3, 5, 5, 8, 9, 1, 3, 4, 1, 2, 3
                )
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> assertRandomNumberInRangeTest(
                        () -> {
                            run("246", "1345", "4", "597", "589", "1", "134", "1", "123", "2");
                            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                        },
                        1, 3, 5, 5, 8, 9, 1, 3, 4, 1, 2, 3
                )
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> assertRandomNumberInRangeTest(
                        () -> {
                            run("246", "135", "못먹어도 고", "597", "589", "1", "134", "1", "123", "2");
                            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                        },
                        1, 3, 5, 5, 8, 9, 1, 3, 4, 1, 2, 3
                )
        ).isInstanceOf(IllegalArgumentException.class);
    }



    @Test
    @DisplayName("예외_테스트_알맞지_않은_길이")
    void valid_string_length() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외_테스트_숫자가_아닌_값")
    void valid_not_number() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1숫자"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("15육"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외_테스트_중복된_숫자")
    void valid_duplicate_number() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("133"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
