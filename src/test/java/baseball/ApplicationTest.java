package baseball;

import baseball.domain.Calculator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    @DisplayName("한 세트진행중 플레이어가 입력한 숫자 검증")
    class UserAnswerTest {

        @Test
        @DisplayName("숫자가 4자리일 때")
        void inputDataTest1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("빈 문자열일 때")
        void inputDataTest2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("   "))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("숫자와 공백이 함께 주어질 때")
        void inputDataTest3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("3  "))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("공백과 숫자가 함께 주어질 때")
        void inputDataTest4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("  4"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

    }

    @Nested
    @DisplayName("한 세트후 플레이어의 리플레이 의사여부 입력값 테스트")
    class UserReplayAnswerTest {

        @Test
        @DisplayName("1을 연속으로 입력할 때")
        void userReplayAnswerTest1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                            () -> run("321", "123", "11"), 1, 2, 3))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("2를 연속으로 입력할 때")
        void userReplayAnswerTest2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                            () -> run("321", "123", "22"), 1, 2, 3))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("빈 문자열을 입력할 때")
        void userReplayAnswerTest3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                            () -> run("321", "123", " "), 1, 2, 3))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("1과 공백을 함께 입력할 때")
        void userReplayAnswerTest4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                            () -> run("321", "123", "1 "), 1, 2, 3))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("2와 공백을 함께 입력할 때")
        void userReplayAnswerTest5() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                            () -> run("321", "123", " 2"), 1, 2, 3))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("숫자가 아닌 값을 입력할 때")
        void userReplayAnswerTest6() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                            () -> run("321", "123", "aa"), 1, 2, 3))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("1과 2를 같이 입력할 때")
        void userReplayAnswerTest7() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                            () -> run("321", "123", "12"), 1, 2, 3))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Nested
    @DisplayName("계산 기능 테스트")
    class calculateTest {

        @Test
        @DisplayName("볼 갯수 계산 테스트")
        void calculateBallTest() {
            List<String> computerAnswerList = List.of("1", "2", "3");
            List<String> userAnswerList = List.of("3", "2", "1");
            Calculator calculator = new Calculator(computerAnswerList, userAnswerList);
            int ballCount = calculator.getBallResult();
            assertThat(ballCount).isEqualTo(2);
        }

        @Test
        @DisplayName("스트라이크 갯수 계산 테스트")
        void calculateStrikeTest() {
            List<String> computerAnswerList = List.of("1", "2", "3");
            List<String> userAnswerList = List.of("1", "2", "4");
            Calculator calculator = new Calculator(computerAnswerList, userAnswerList);
            int strikeCount = calculator.getStrikeResult();
            assertThat(strikeCount).isEqualTo(2);
        }

    }

    @Nested
    @DisplayName("게임 실행 중 출력되는 메세지 테스트")
    class MessagePrintTest{

        @Test
        @DisplayName("계산 결과 출력 메세지 테스트")
        void ballMessageTest() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("312", "213", "654","123", "1", "798", "987", "2");
                        assertThat(output()).contains("3볼", "2볼 1스트라이크", "낫싱", "3스트라이크", "3볼", "3스트라이크", "게임 종료");
                    },
                    1, 2, 3, 9, 8, 7
            );
        }

        @Test
        @DisplayName("게임 전체 메세지 테스트")
        void entireMessageTest() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("592", "925", "734", "1", "374", "592", "2");
                        assertThat(output()).isEqualTo(
                                "숫자 야구 게임을 시작합니다.\n" +
                                        "숫자를 입력해주세요 : " +
                                        "낫싱\n" +
                                        "숫자를 입력해주세요 : " +
                                        "낫싱\n" +
                                        "숫자를 입력해주세요 : " +
                                        "3스트라이크\n" +
                                        "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n" +
                                        "숫자를 입력해주세요 : " +
                                        "낫싱\n" +
                                        "숫자를 입력해주세요 : " +
                                        "3스트라이크\n" +
                                        "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    },
                    7, 3, 4, 5, 9, 2
            );
        }

    }




}
