package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    @Nested
    class NormalFlowTest extends NsTest{
        @Test
        void 게임_1회_종료() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "137", "135", "2");
                        assertThat(output()).contains("낫싱", "2스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5
            );
        }

        @Test
        void 게임_2회_종료() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("147", "417", "453", "459", "1", "315", "351", "2");
                        assertThat(output()).contains("1볼", "1스트라이크", "2스트라이크", "3스트라이크", "게임 종료",
                                "2볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    4, 5, 9, 3, 5, 1
            );
        }

        @Test
        void 게임_3회_종료() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("156", "641", "631", "1", "762", "726", "1", "123", "587", "2");
                        assertThat(output()).contains("2볼", "2스트라이크", "3스트라이크", "게임 종료",
                                "2볼 1스트라이크", "3스트라이크", "게임 종료",
                                "낫싱", "3스트라이크", "게임 종료");
                    },
                    6, 3, 1, 7, 2, 6, 5, 8, 7
            );
        }

        @Override
        public void runMain() {
            Application.main(new String[]{});
        }
    }

    @Nested
    class InputExceptionTest extends NsTest {
        @Test
        void 게임종료_후_재시작_예외 () {
            assertRandomNumberInRangeTest(
                    () -> {
                        assertThatThrownBy(() -> runException("123", "9"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("1 혹은 2 이외의 문자를 입력 하셨습니다.");
                    },
                    1, 2, 3
            );

            assertRandomNumberInRangeTest(
                    () -> {
                        assertThatThrownBy(() -> runException("123", "@"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("1 혹은 2 이외의 문자를 입력 하셨습니다.");
                    },
                    1, 2, 3
            );

            assertRandomNumberInRangeTest(
                    () -> {
                        assertThatThrownBy(() -> runException("123", "123"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("한 자리를 초과하는 문자를 입력하셨습니다.");
                    },
                    1, 2, 3
            );
        }

        @Test
        void 입력이_세자리가_아닌경우() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력하신 숫자가 세 자리가 아닙니다.")
            );
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력하신 숫자가 세 자리가 아닙니다.")
            );
        }

        @Test
        void 입력이_1부터_9사이의_숫자가_아닌경우() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("q12"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력하신 내용 중에 숫자가 아니거나, 0인 값이 있습니다.")
            );

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("qwe"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력하신 내용 중에 숫자가 아니거나, 0인 값이 있습니다.")
            );
        }

        @Test
        void 같은_숫자를_입력한경우() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("122"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력하신 내용 중에 중복되는 숫자가 있습니다.")
            );

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("333"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력하신 내용 중에 중복되는 숫자가 있습니다.")
            );
        }

        @Override
        public void runMain() {
            Application.main(new String[]{});
        }
    }

    @Nested
    class NumberGenerateTest {
        NumberGenerator generator = new NumberGenerator();

        @Test
        void 생성된_난수_3개인지_확인() {
            generator.generateNumber();
            assertSame(3, generator.getNumbers().size());

        }

        @Test
        void 생성된_난수_범위_확인 () {
            generator.generateNumber();

            for(int number : generator.getNumbers())
                assertTrue(1 <= number && number <= 9);
        }

        @Test
        void 생성된_난수_중복확인() {
            generator.generateNumber();

            for(int number : generator.getNumbers())
                assertEquals(1, Collections.frequency(generator.getNumbers(), number));
        }
    }

    @Nested
    class JudgementTest {
        Judge judge = new Judge();
        List<Integer> answer = List.of(7, 9, 1);

        @Test
        void 낫싱_판정 () {
            String result = judge.judgement(answer, List.of(3, 6, 8));
            assertSame("낫싱", result);

            result = judge.judgement(answer, List.of(5, 4, 3));
            assertSame("낫싱", result);
        }

        @Test
        void 볼_판정 () {
            String result = judge.judgement(answer, List.of(1, 2, 3));
            assertEquals("1볼", result);

            result = judge.judgement(answer, List.of(9, 7, 2));
            assertEquals("2볼", result);

            result = judge.judgement(answer, List.of(1, 7, 9));
            assertEquals("3볼", result);
        }

        @Test
        void 스트라이크_판정 () {
            String result = judge.judgement(answer, List.of(7, 2, 3));
            assertEquals("1스트라이크", result);

            result = judge.judgement(answer, List.of(7, 9, 3));
            assertEquals("2스트라이크", result);

            result = judge.judgement(answer, List.of(7, 9, 1));
            assertEquals("3스트라이크", result);
        }

        @Test
        void 볼_스트라이크_판정 () {
            String result = judge.judgement(answer, List.of(1, 9, 7));
            assertEquals("2볼 1스트라이크", result);

            result = judge.judgement(answer, List.of(3, 9, 7));
            assertEquals("1볼 1스트라이크", result);
        }
    }
}
