package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.GameInputException;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Nested
    class GameInputExceptionTest {
        GameInputException gameInputException = new GameInputException(3);

        @Nested
        @DisplayName("게임중 입력에서 예외 발생 케이스 체크")
        class NegativeGameInputExceptionTest {
            @ParameterizedTest
            @ValueSource(strings = {"abc", "-13", "1234", "abcd", "", "+15", "057", "221", "222", "a93", "a03k"})
            void testNegativeCaseZ(String userInputTest) {
                assertThatThrownBy(() -> gameInputException.checkUserInput(userInputTest)).isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("게임중 입력에서 예외 미발생 케이스 체크")
        class PositiveGameInputExceptionTest {
            @ParameterizedTest
            @ValueSource(strings = {"123", "234", "921"})
            void testPositiveCase(String userInputTest) {
                try {
                    gameInputException.checkUserInput(userInputTest);
                } catch (IllegalArgumentException illegalArgumentException) {
                    assertEquals(0,1);
                }

            }
        }
    }

    @Nested
    @DisplayName("게임중 유저 입력에 대한 반응 출력")
    class GameUserInputTest {
        private Baseball baseballTest = new Baseball();

        private void runMainGame(String ... args) {
            final byte[] buf = String.join("\n", args).getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            baseballTest.play();
        }

        @Test
        void testMainGame() {
            assertRandomNumberInRangeTest(
                    () -> {
                        runMainGame("456", "145", "243", "321", "365", "123");
                        String[] expectedAnswer = {"낫싱", "1스트라이크", "1볼 1스트라이크", "2볼 1스트라이크", "1볼", "3스트라이크"};

                        assertEquals(output(), "숫자를 입력해주세요 : " + String.join("\r\n숫자를 입력해주세요 : ", expectedAnswer));
                    },
                    1, 2,3
            );
        }
    }
}
