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

    @Nested
    @DisplayName("성공 테스트")
    class SuccessTest {
        @Test
        void 성공_테스트1() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123", "234", "245", "436", "589", "734", "384", "394", "2");
                        assertThat(output()).contains("숫자 야구 게임을 시작합니다.",
                                "1볼", "1볼 1스트라이크", "1볼", "2볼",
                                "1볼 1스트라이크", "1볼 1스트라이크", "3스트라이크",
                                "3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    },
                    3, 9, 4
            );
        }

        @Test
        void 성공_테스트2() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123", "789", "456", "357", "589", "159", "951", "1", "148", "2");
                        assertThat(output()).contains("숫자 야구 게임을 시작합니다.",
                                "1볼", "1볼", "1스트라이크", "1스트라이크",
                                "2볼 1스트라이크", "3스트라이크",
                                "3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.",
                                "3스트라이크");
                    },
                    9, 5, 1, 1, 4, 8
            );
        }

        @Test
        void 전체_스크립트_테스트() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123", "456", "789",
                                "973", "719", "738",
                                "782", "389", "839",
                                "1",
                                "354", "178", "987",
                                "287", "986", "981",
                                "2");
                        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.\n" +
                                "숫자를 압력해주세요 : 1볼\n" +
                                "숫자를 압력해주세요 : 낫싱\n" +
                                "숫자를 압력해주세요 : 1볼 1스트라이크\n" +
                                "숫자를 압력해주세요 : 2볼\n" +
                                "숫자를 압력해주세요 : 1스트라이크\n" +
                                "숫자를 압력해주세요 : 1볼 1스트라이크\n" +
                                "숫자를 압력해주세요 : 1볼\n" +
                                "숫자를 압력해주세요 : 2볼 1스트라이크\n" +
                                "숫자를 압력해주세요 : 3스트라이크\n" +
                                "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n" +
                                "숫자를 압력해주세요 : 낫싱\n" +
                                "숫자를 압력해주세요 : 2볼\n" +
                                "숫자를 압력해주세요 : 2스트라이크\n" +
                                "숫자를 압력해주세요 : 1스트라이크\n" +
                                "숫자를 압력해주세요 : 2스트라이크\n" +
                                "숫자를 압력해주세요 : 3스트라이크\n" +
                                "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    },
                    8, 3, 9, 9, 8, 1
            );
        }
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Nested
    @DisplayName("예외 테스트")
    class ExceptionTest {

        @Test
        void 숫자를_입력하지_않은_경우() {
            assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("asdf"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 숫자 입력입니다. 입력 문자: asdf"),
                1, 2, 3
            );
        }

        @Test
        void 같은_숫자를_입력한_경우() {
            assertRandomNumberInRangeTest(
                    () -> assertThatThrownBy(() -> run("111"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("서로 다른 숫자를 입력해주세요. 입력 문자: 111"),
                    1, 2, 3
            );
        }

        @Test
        void 세자리_숫자를_입력하지_않은_경우1() {
            assertRandomNumberInRangeTest(
                    () -> assertThatThrownBy(() -> run("1114"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("123~789 사이의 숫자를 입력해주세요. 입력 문자: 1114"),
                    1, 2, 3
            );
        }

        @Test
        void 세자리_숫자를_입력하지_않은_경우2() {
            assertRandomNumberInRangeTest(
                    () -> assertThatThrownBy(() -> run("11"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("123~789 사이의 숫자를 입력해주세요. 입력 문자: 11"),
                    1, 2, 3
            );
        }

        @Test
        void 없는_상태_코드_입력한_경우() {
            assertRandomNumberInRangeTest(
                    () -> assertThatThrownBy(() -> run("123", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("1 또는 2을 입력해주세요. 입력 문자: 3"),
                    1, 2, 3
            );
        }

        @Test
        void 숫자에_0이_포함된_경우() {
            assertRandomNumberInRangeTest(
                    () -> assertThatThrownBy(() -> run("103"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("1~9 사이의 숫자를 입력해주세요. 입력 문자: 103"),
                    1, 2, 3
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
