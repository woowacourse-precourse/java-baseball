package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;



class ApplicationTest extends NsTest {
    @DisplayName("올바르게 숫자가 생성되었는지 테스트")
    @Test
    void 올바른_숫자_생성_테스트() {
        //given
        Computer computer = new Computer();

        //when
        computer.generateNumber();
        String number = computer.getNumber();

        //then
        assertThat(Validator.isValid(number)).isEqualTo(true);
    }

    @DisplayName("올바른 게임 결과가 나오는지 테스트")
    @Nested
    class CheckGameResult {
        @Test
        void 게임종료_후_재시작() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "1", "597", "589", "2");
                        assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5, 5, 8, 9
            );
        }

        @Test
        void 게임종료_후_완전_종료() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123", "465", "564", "423", "456", "2");
                        assertThat(output()).contains("낫싱", "2볼 1스트라이크", "3볼", "1스트라이크", "게임 종료");
                    },
                    4, 5, 6

            );
        }
    }

    @DisplayName("예외 케이스 테스트")
    @Nested
    class ExceptionHandle {
        @Test
        void 예외_글자길이_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 예외_중복문자_테스트() {
            Player player = new Player();

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> player.setNumber("313"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 예외_0포함_테스트() {
            Player player = new Player();

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> player.setNumber("130"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 예외_잘못된_게임_종료값_입력() {
            assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                    () -> {
                        run("456", "0");
                        assertThat(output()).contains("3스트라이크");
                    },
                    4, 5, 6
            )).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
