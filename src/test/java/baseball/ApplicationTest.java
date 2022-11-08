package baseball;

import baseball.model.BaseballNumbers;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Nested
    class Task1Test {
        @Test
        void 랜덤숫자_개수_3개인지() {
            BaseballNumbers computerNumber = new BaseballNumbers();

            assertThatThrownBy(() -> computerNumber.getNumber(3))
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }

        @Test
        void 랜덤숫자_범위_확인() {
            BaseballNumbers computerNumber = new BaseballNumbers();

            for (int i = 0; i < 3; i++) {
                assertThat(computerNumber.getNumber(i)).isBetween(1, 9);
            }
        }

        @Test
        void 랜덤숫자_중복_확인() {
            BaseballNumbers computerNumber = new BaseballNumbers();
            Set<Integer> numbers = new HashSet<>();

            for (int i = 0; i < 3; i++) {
                numbers.add(computerNumber.getNumber(i));
            }

            assertThat(numbers.size()).isEqualTo(3);
        }
    }

    @Nested
    class Task2Test {
        @Test
        void 사용자입력_예외_길이_불일치() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 사용자입력_예외_숫자_범위_초과() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("012"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 사용자입력_예외_숫자_외_문자_포함() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abc"))
                            .isInstanceOf(IllegalArgumentException.class)
            );

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("12a"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 사용자입력_예외_숫자_중복() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("112"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    class Task3Test {
        @Test
        void 게임결과_정답() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123", "2");
                        assertThat(output()).contains("3스트라이크", "게임 종료");
                    },
                    1, 2, 3
            );
        }

        @Test
        void 게임결과_낫싱_출력() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("678", "123", "2");
                        assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                    },
                    1, 2, 3
            );
        }

        @Test
        void 게임결과_볼_스트라이크_내용_출력() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("142", "123", "2");
                        assertThat(output()).contains("1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 2, 3
            );
        }
    }

    @Nested
    class Task4Test{
        @Test
        void 게임_종료_후_재시작() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "759", "1", "123", "2");
                        assertThat(output()).contains("낫싱", "1볼 0스트라이크", "3스트라이크", "3스트라이크", "게임 종료");
                    },
                    7, 5, 9, 1, 2, 3
            );
        }
    }

//    @Test
//    void 게임종료_후_재시작() {
//        assertRandomNumberInRangeTest(
//                () -> {
//                    run("246", "135", "1", "597", "589", "2");
//                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
//                },
//                1, 3, 5, 5, 8, 9
//        );
//    }
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("1234"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
