package baseball;

import baseball.dto.Score;
import baseball.utility.PlayerNumberValidator;
import baseball.utility.ResultEvaluator;
import camp.nextstep.edu.missionutils.test.NsTest;
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

    @Test
    void globalTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("957", "1", "312", "132", "123", "1", "123", "456", "987", "794", "795", "2");
                    assertThat(output()).contains("3스트라이크", "3볼", "2볼 1스트라이크", "3스트라이크",
                            "낫싱", "2볼", "2스트라이크", "3스트라이크", "게임 종료");
                },
                9, 5, 7, 1, 2, 3, 7, 9, 5
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void exceptionTest1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("let it crash"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void exceptionTest2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void exceptionTest3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("989"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void exceptionTest4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("98 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void isPlayerNumberValidTest() {
        assertThat(PlayerNumberValidator.isPlayerNumberValid("333")).isEqualTo(false);
        assertThat(PlayerNumberValidator.isPlayerNumberValid("121")).isEqualTo(false);
        assertThat(PlayerNumberValidator.isPlayerNumberValid("123")).isEqualTo(true);
        assertThat(PlayerNumberValidator.isPlayerNumberValid("1234")).isEqualTo(false);
        assertThat(PlayerNumberValidator.isPlayerNumberValid("12a")).isEqualTo(false);
        assertThat(PlayerNumberValidator.isPlayerNumberValid("12가")).isEqualTo(false);
        assertThat(PlayerNumberValidator.isPlayerNumberValid("129")).isEqualTo(true);
        assertThat(PlayerNumberValidator.isPlayerNumberValid("1 9")).isEqualTo(false);
        assertThat(PlayerNumberValidator.isPlayerNumberValid(null)).isEqualTo(false);
        assertThat(PlayerNumberValidator.isPlayerNumberValid("")).isEqualTo(false);
    }

    @Test
    void isNumericLiteralBetweenOneAndNine() {
        assertThat(PlayerNumberValidator.isNumericLiteralBetweenOneAndNine('0')).isEqualTo(false);
        assertThat(PlayerNumberValidator.isNumericLiteralBetweenOneAndNine('1')).isEqualTo(true);
        assertThat(PlayerNumberValidator.isNumericLiteralBetweenOneAndNine('2')).isEqualTo(true);
        assertThat(PlayerNumberValidator.isNumericLiteralBetweenOneAndNine('3')).isEqualTo(true);
        assertThat(PlayerNumberValidator.isNumericLiteralBetweenOneAndNine(' ')).isEqualTo(false);
        assertThat(PlayerNumberValidator.isNumericLiteralBetweenOneAndNine('\b')).isEqualTo(false);
    }

    @Test
    void translateScoreToHintTest() {
        assertThat(ResultEvaluator.translateScoreToHint(new Score(1, 2))).isEqualTo("1볼 2스트라이크");
        assertThat(ResultEvaluator.translateScoreToHint(new Score(0, 3))).isEqualTo("3스트라이크");
        assertThat(ResultEvaluator.translateScoreToHint(new Score(0, 0))).isEqualTo("낫싱");

    }

    @Test
    void getHintTest() {
        String computerNumber = "987";

        assertThat(ResultEvaluator.getHint(computerNumber, "912")).isEqualTo("1스트라이크");
        assertThat(ResultEvaluator.getHint(computerNumber, "987")).isEqualTo("3스트라이크");
        assertThat(ResultEvaluator.getHint(computerNumber, "187")).isEqualTo("2스트라이크");
        assertThat(ResultEvaluator.getHint(computerNumber, "937")).isEqualTo("2스트라이크");
        assertThat(ResultEvaluator.getHint(computerNumber, "798")).isEqualTo("3볼");
        assertThat(ResultEvaluator.getHint(computerNumber, "718")).isEqualTo("2볼");
    }
}
