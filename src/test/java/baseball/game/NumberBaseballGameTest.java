package baseball.game;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberBaseballGameTest {

    @BeforeEach
    void powerOn() {
        NumberBaseballGame.powerOn();
    }

    @AfterEach
    void powerOff() {
        NumberBaseballGame.powerOff();
    }

    @Nested
    class MainTest extends NsTest {

        @Test
        void 게임정상종료() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("435", "126", "897", "893", "839");
                        assertThat(output()).contains("1스트라이크", "낫싱", "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    8, 3, 9
            );
        }

        @Test
        void 게임중_예외발생_숫자_3자리X() {
            assertRandomNumberInRangeTest(
                    () -> {
                        assertThatThrownBy(() -> runException("456", "134", "12"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("3자리 숫자를 입력해주세요.");
                        assertThat(output()).contains("낫싱", "1볼 1스트라이크");
                    },
                    1, 2, 3
            );
        }

        @Test
        void 게임중_예외발생_only_자연수X() {
            assertRandomNumberInRangeTest(
                    () -> {
                        assertThatThrownBy(() -> runException("238", "928", "1a2"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("1 ~ 9까지의 숫자만을 입력해주세요.");
                        assertThat(output()).contains("2볼", "1스트라이크");
                    },
                    1, 2, 3
            );
        }

        @Test
        void 게임중_예외발생_unique_숫자X() {
            assertRandomNumberInRangeTest(
                    () -> {
                        assertThatThrownBy(() -> runException("127", "327", "122"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("각 자리의 숫자가 서로 다르도록 입력해주세요.");
                        assertThat(output()).contains("2스트라이크", "1볼 1스트라이크");
                    },
                    1, 2, 3
            );
        }

        @Override
        protected void runMain() {
            NumberBaseballGame.start();
        }
    }

    @Nested
    class MethodTest {

        private PrintStream standardOut;
        private OutputStream captor;

        @BeforeEach
        protected final void init() {
            standardOut = System.out;
            captor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captor));
        }

        @AfterEach
        protected final void printOutput() {
            System.setOut(standardOut);
            System.out.println(output());
        }

        protected final String output() {
            return captor.toString().trim();
        }

        @Test
        void pickAnswerNumberList_테스트() {
            NumberBaseballGame.pickAnswerNumberList();
            List<Integer> answerNumberList = NumberBaseballGame.getAnswerNumberList();

            assertThat(answerNumberList.size()).isEqualTo(3);
            assertThat(answerNumberList).allMatch(num -> num >= 1 && num <= 9);
            assertThat(answerNumberList).allMatch(src ->
                    answerNumberList.stream()
                            .filter(dest -> Objects.equals(dest, src))
                            .count() == 1);
        }

        @Test
        void inputPlayerNumberList_테스트() {
            String playerInput = "317";
            final byte[] buf = playerInput.getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            NumberBaseballGame.inputPlayerNumberList();

            List<Integer> playerNumberList = NumberBaseballGame.getPlayerNumberList();
            assertThat(playerNumberList).containsExactly(3, 1, 7);
        }

        @Test
        void inputPlayerNumberList_예외_테스트_숫자_3자리X() {
            assertThatThrownBy(() -> {
                String playerInput = "12345";
                final byte[] buf = playerInput.getBytes();
                System.setIn(new ByteArrayInputStream(buf));
                NumberBaseballGame.inputPlayerNumberList();
            })
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("3자리 숫자를 입력해주세요.");
        }

        @Test
        void inputPlayerNumberList_예외_테스트_only_자연수X() {
            assertThatThrownBy(() -> {
                String playerInput = "1a4";
                final byte[] buf = playerInput.getBytes();
                System.setIn(new ByteArrayInputStream(buf));
                NumberBaseballGame.inputPlayerNumberList();
            })
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1 ~ 9까지의 숫자만을 입력해주세요.");
        }

        @Test
        void inputPlayerNumberList_예외_테스트_unique_숫자X() {
            assertThatThrownBy(() -> {
                String playerInput = "555";
                final byte[] buf = playerInput.getBytes();
                System.setIn(new ByteArrayInputStream(buf));
                NumberBaseballGame.inputPlayerNumberList();
            })
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("각 자리의 숫자가 서로 다르도록 입력해주세요.");
        }

        @Test
        void countBallAndStrike_테스트() {
            addAllToAnswerNumberList(1, 2, 3);

            addAllToPlayerNumberList(4, 5, 6);
            NumberBaseballGame.countBallAndStrike();
            assertThat(NumberBaseballGame.getBall()).isEqualTo(0);
            assertThat(NumberBaseballGame.getStrike()).isEqualTo(0);

            addAllToPlayerNumberList(3, 2, 1);
            NumberBaseballGame.countBallAndStrike();
            assertThat(NumberBaseballGame.getBall()).isEqualTo(2);
            assertThat(NumberBaseballGame.getStrike()).isEqualTo(1);

            addAllToPlayerNumberList(2, 3, 1);
            NumberBaseballGame.countBallAndStrike();
            assertThat(NumberBaseballGame.getBall()).isEqualTo(3);
            assertThat(NumberBaseballGame.getStrike()).isEqualTo(0);

            addAllToPlayerNumberList(1, 2, 3);
            NumberBaseballGame.countBallAndStrike();
            assertThat(NumberBaseballGame.getBall()).isEqualTo(0);
            assertThat(NumberBaseballGame.getStrike()).isEqualTo(3);
        }

        @Test
        void countBallAndStrike_예외_테스트() {
            addAllToAnswerNumberList(1, 2, 3, 4);
            addAllToPlayerNumberList(4, 5, 6);
            assertThatThrownBy(NumberBaseballGame::countBallAndStrike)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("시스템 오류로 정답과 답안이 유효하지 않은 값으로 변경되었습니다.");

            addAllToAnswerNumberList(1, 2, 3);
            addAllToPlayerNumberList(0, 5, 6);
            assertThatThrownBy(NumberBaseballGame::countBallAndStrike)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("시스템 오류로 정답과 답안이 유효하지 않은 값으로 변경되었습니다.");

            addAllToAnswerNumberList(1, 2, 3);
            addAllToPlayerNumberList(4, 5, 5);
            assertThatThrownBy(NumberBaseballGame::countBallAndStrike)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("시스템 오류로 정답과 답안이 유효하지 않은 값으로 변경되었습니다.");
        }

        @Test
        void printHint_테스트() {
            setBallAndStrike(0, 0);
            NumberBaseballGame.printHint();
            assertThat(output()).contains("낫싱");

            setBallAndStrike(1, 2);
            NumberBaseballGame.printHint();
            assertThat(output()).contains("1볼 2스트라이크");

            setBallAndStrike(2, 1);
            NumberBaseballGame.printHint();
            assertThat(output()).contains("2볼 1스트라이크");

            setBallAndStrike(3, 0);
            NumberBaseballGame.printHint();
            assertThat(output()).contains("3볼");

            setBallAndStrike(0, 3);
            NumberBaseballGame.printHint();
            assertThat(output()).contains("3스트라이크");
        }

        @Test
        void printHint_예외_테스트() {
            setBallAndStrike(4, 0);
            assertThatThrownBy(NumberBaseballGame::printHint)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("ball, strike 계산에 오류가 발생하였습니다.");

            setBallAndStrike(3, -1);
            assertThatThrownBy(NumberBaseballGame::printHint)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("ball, strike 계산에 오류가 발생하였습니다.");

            setBallAndStrike(2, 3);
            assertThatThrownBy(NumberBaseballGame::printHint)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("ball, strike 계산에 오류가 발생하였습니다.");
        }

        private void addAllToAnswerNumberList(int... nums) {
            List<Integer> answerNumberList = NumberBaseballGame.getAnswerNumberList();
            answerNumberList.clear();
            Arrays.stream(nums).forEach(answerNumberList::add);
        }

        private void addAllToPlayerNumberList(int... nums) {
            List<Integer> playerNumberList = NumberBaseballGame.getPlayerNumberList();
            playerNumberList.clear();
            Arrays.stream(nums).forEach(playerNumberList::add);
        }

        private void setBallAndStrike(int ball, int strike) {
            NumberBaseballGame.setBall(ball);
            NumberBaseballGame.setStrike(strike);
        }
    }
}
