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
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    @DisplayName("정답 맞춘 후 게임 종료(1)")
    void play_exit_1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "2");
                    assertThat(output()).contains("3스트라이크","게임 종료");
                },
                2, 4, 6
        );
    }

    @Test
    @DisplayName("정답 맞춘 후 게임 종료(2)")
    void play_exit_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("731", "135", "729", "742", "724", "2");
                    assertThat(output()).contains("1스트라이크", "낫싱", "2스트라이크", "2볼 1스트라이크", "3스트라이크","게임 종료");
                },
                7, 2, 4
        );
    }

    @Test
    @DisplayName("게임 중 숫자 4자리 입력")
    void input_four_number() {
        assertThatThrownBy(
                () -> assertRandomNumberInRangeTest(
                        () -> {
                            run("731", "1359", "729", "742", "724", "2");
                            assertThat(output()).contains("1스트라이크", "낫싱", "2스트라이크", "2볼 1스트라이크", "3스트라이크","게임 종료");
                        },
                        7,2,4
                )
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 중 문자 입력")
    void input_character() {
        assertThatThrownBy(
                () -> assertRandomNumberInRangeTest(
                        () -> {
                            run("976", "132", "안녕", "135", "2");
                            assertThat(output()).contains("낫싱", "2스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                        },
                        1, 3, 5
                )
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 중 중복된 숫자 입력")
    void input_duplicate_number() {
        assertThatThrownBy(
                () -> assertRandomNumberInRangeTest(
                        () -> {
                            run("731", "135", "729", "999", "724", "2");
                            assertThat(output()).contains("1스트라이크", "낫싱", "2스트라이크", "2볼 1스트라이크", "3스트라이크","게임 종료");
                        },
                        7,2,4
                )
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
