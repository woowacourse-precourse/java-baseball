package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    BaseBallGame testGame = new BaseBallGame();
    public static final int COMPUTER_NUMBERS_SIZE = 3;
    @Nested
    class GameStartTest {
        @Test
        void 게임시작하면_출력되는_시작문구_확인() {
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            testGame.printGameStart();

            String actualOutput = out.toString()
                    .replace(System.getProperty("line.separator").toString(), "");

            String expectedOutput = "숫자 야구 게임을 시작합니다.";
            assertThat(actualOutput).isEqualTo(actualOutput);
        }
    }
    @Nested
    class GamePrepareTest {
        @BeforeEach
        void 게임준비시키기() {
            testGame.prepareGame();
        }
        @Test
        void 게임시작하면_성공여부가_초기화되는지_확인() {
            assertThat(testGame.success).isFalse();
        }
        @Test
        void 게임시작하면_설정되는_수가_3개인지_확인() {
            assertThat(testGame.computerNumbers.size()).isEqualTo(COMPUTER_NUMBERS_SIZE);
        }
        @Test
        void 게임시작하면_설정되는_수가_서로_다른지_확인() {
            // 만약 중복되는 수가 있다면 hashSet으로 변환했을 때 길이가 줄어든다
            HashSet<Integer> computerNumbers = new HashSet<>(testGame.computerNumbers);
            assertThat(computerNumbers.size()).isEqualTo(COMPUTER_NUMBERS_SIZE);
        }
    }

    @Nested
    class GameProceedTest {
        @Test
        void 사용자_입력요청_문구_확인() {
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            testGame.printInputRequest();

            String actualOutput = out.toString()
                    .replace(System.getProperty("line.separator").toString(), "");

            String expectedOutput = "숫자를 입력해주세요 : ";
            assertThat(actualOutput).isEqualTo(actualOutput);
        }
        @Nested
        class ExceptionTest{
            @Test
            void 사용자입력이_3글자가_아니면_오류발생() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("1234"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }
            @Test
            void 사용자입력이_숫자가_아니면_오류발생() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("12a"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }
            @Test
            void 사용자입력에_0이_있으면_오류발생() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("102"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }
            @Test
            void 사용자입력에_중복된_수가_있으면_오류발생() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("112"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }
        }

        @Nested
        class BallAndStrikeCountTest {
            @BeforeEach
            void 컴퓨터_수_세팅() {
                testGame.computerNumbers = List.of(1, 2, 3);
            }
            @Test
            void case1_3스트라이크() {
                testGame.userNumbers = List.of(1, 2, 3);
                Map<String, Integer> gameResult = testGame.getGameResult();
                int ball = gameResult.get("ball");
                int strike = gameResult.get("strike");

                assertThat(ball).isEqualTo(0);
                assertThat(strike).isEqualTo(3);
            }
            @Test
            void case2_3볼() {
                testGame.userNumbers = List.of(2, 3, 1);
                Map<String, Integer> gameResult = testGame.getGameResult();
                int ball = gameResult.get("ball");
                int strike = gameResult.get("strike");

                assertThat(ball).isEqualTo(3);
                assertThat(strike).isEqualTo(0);
            }
            @Test
            void case3_2볼_1스트라이크() {
                testGame.userNumbers = List.of(1, 3, 2);
                Map<String, Integer> gameResult = testGame.getGameResult();
                int ball = gameResult.get("ball");
                int strike = gameResult.get("strike");

                assertThat(ball).isEqualTo(2);
                assertThat(strike).isEqualTo(1);
            }
            @Test
            void case4_1볼_1스트라이크() {
                testGame.userNumbers = List.of(1, 4, 2);
                Map<String, Integer> gameResult = testGame.getGameResult();
                int ball = gameResult.get("ball");
                int strike = gameResult.get("strike");

                assertThat(ball).isEqualTo(1);
                assertThat(strike).isEqualTo(1);
            }
            @Test
            void case5_0볼_0스트라이크() {
                testGame.userNumbers = List.of(4, 5, 6);
                Map<String, Integer> gameResult = testGame.getGameResult();
                int ball = gameResult.get("ball");
                int strike = gameResult.get("strike");

                assertThat(ball).isEqualTo(0);
                assertThat(strike).isEqualTo(0);
            }
        }

        @Nested
        class GameResultMessageTest {
            @Test
            void case1_3스트라이크() {
                Map<String, Integer> gameResult = new HashMap<>();
                gameResult.put("ball", 0);
                gameResult.put("strike", 3);

                String gameResultMessage = testGame.gameMessageDisplay
                        .getGameResultMessage(gameResult);
                assertThat(gameResultMessage).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
            @Test
            void case2_3볼() {
                Map<String, Integer> gameResult = new HashMap<>();
                gameResult.put("ball", 3);
                gameResult.put("strike", 0);

                String gameResultMessage = testGame.gameMessageDisplay
                        .getGameResultMessage(gameResult);
                assertThat(gameResultMessage).isEqualTo("3볼");
            }
            @Test
            void case3_2볼_1스트라이크() {
                Map<String, Integer> gameResult = new HashMap<>();
                gameResult.put("ball", 2);
                gameResult.put("strike", 1);

                String gameResultMessage = testGame.gameMessageDisplay
                        .getGameResultMessage(gameResult);
                assertThat(gameResultMessage).isEqualTo("2볼 1스트라이크");
            }
            @Test
            void case4_1볼_1스트라이크() {
                Map<String, Integer> gameResult = new HashMap<>();
                gameResult.put("ball", 1);
                gameResult.put("strike", 1);

                String gameResultMessage = testGame.gameMessageDisplay
                        .getGameResultMessage(gameResult);
                assertThat(gameResultMessage).isEqualTo("1볼 1스트라이크");
            }
            @Test
            void case5_0볼_0스트라이크() {
                Map<String, Integer> gameResult = new HashMap<>();
                gameResult.put("ball", 0);
                gameResult.put("strike", 0);

                String gameResultMessage = testGame.gameMessageDisplay
                        .getGameResultMessage(gameResult);
                assertThat(gameResultMessage).isEqualTo("낫싱");
            }
        }
        @Test
        void 스트라이크가_3개면_성공() {
            Map<String, Integer> gameResult = new HashMap<>();
            gameResult.put("ball", 0);
            gameResult.put("strike", 3);

            assertThat(testGame.isSuccess(gameResult)).isTrue();
        }
        @Test
        void 스트라이크가_3개아니면_실패() {
            Map<String, Integer> gameResult = new HashMap<>();
            gameResult.put("ball", 2);
            gameResult.put("strike", 1);

            assertThat(testGame.isSuccess(gameResult)).isFalse();
        }
    }

    @Nested
    class GameTerminateOrRestartTest {
        @Test
        void 종료_또는_재시작_출력문구확인() {
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            testGame.gameMessageDisplay.printStopOrRegameRequestMessage();

            String actualOutput = out.toString()
                    .replace(System.getProperty("line.separator").toString(), "");

            String expectedOutput = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
            assertThat(actualOutput).isEqualTo(expectedOutput);
        }
        @Test
        void 맞춘_뒤에_입력시_1이나_2가_아닌_수를_입력하면_예외처리() {
            assertRandomNumberInRangeTest(
                    () -> {
                        assertThatThrownBy(() -> run("123", "3"))
                                .isInstanceOf(IllegalArgumentException.class);
                    },
                    1, 2, 3
            );
        }
    }

    @Test
    void 정답_맞추는_과정_case1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("147", "137", "153", "163", "123", "2");
                    assertThat(output()).contains("1스트라이크", "1볼 1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }
    @Test
    void 정답_맞추는_과정_case2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("791", "891", "291", "219", "912", "192", "129", "123", "2");
                    assertThat(output())
                            .contains("1볼", "2볼", "1볼 1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }
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
}
