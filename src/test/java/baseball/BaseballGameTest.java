package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BaseballGameTest extends NsTest {

    @Test
    void 게임_시작_안내() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "1", "589", "2");
                    assertThat(
                            stream(output().split("\n"))
                                    .filter(word -> word.equals("숫자 야구 게임을 시작합니다."))
                                    .count())
                            .isEqualTo(1);
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 상대방의_수_범위() {
        Baseball baseball = new Baseball();
        List<Integer> computerNumbers = baseball.createComputerNumbers();
        for (Integer computerNumber : computerNumbers) {
            assertThat(computerNumber)
                    .isGreaterThanOrEqualTo(1)
                    .isLessThanOrEqualTo(9);
        }
    }

    @Test
    void 상대방의_서로_다른_임의의_수() {
        Baseball baseball = new Baseball();
        List<Integer> computerNumbers = baseball.createComputerNumbers();
        Integer firstNum = computerNumbers.get(0);
        Integer secondNum = computerNumbers.get(1);
        Integer thirdNum = computerNumbers.get(2);
        assertThat(firstNum).isNotEqualTo(secondNum);
        assertThat(firstNum).isNotEqualTo(thirdNum);
        assertThat(secondNum).isNotEqualTo(thirdNum);
    }

    @Test
    @DisplayName("1볼 1스트라이크")
    void case1() {
        Baseball baseball = new Baseball();
        List<Integer> computerNumbers = List.of(7, 1, 3);
        List<Integer> userNumbers = List.of(1, 2, 3);
        String hint = baseball.getHint(computerNumbers, userNumbers);
        assertThat(hint).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("1볼")
    void oneBall() {
        Baseball baseball = new Baseball();
        List<Integer> computerNumbers = List.of(7, 1, 3);
        List<Integer> userNumbers = List.of(1, 4, 5);
        String hint = baseball.getHint(computerNumbers, userNumbers);
        assertThat(hint).isEqualTo("1볼");
    }

    @Test
    @DisplayName("2볼")
    void twoBall() {
        Baseball baseball = new Baseball();
        List<Integer> computerNumbers = List.of(7, 1, 3);
        List<Integer> userNumbers = List.of(6, 7, 1);
        String hint = baseball.getHint(computerNumbers, userNumbers);
        assertThat(hint).isEqualTo("2볼");
    }

    @Test
    @DisplayName("1스트라이크")
    void oneStrike() {
        Baseball baseball = new Baseball();
        List<Integer> computerNumbers = List.of(7, 1, 3);
        List<Integer> userNumbers = List.of(2, 1, 6);
        String hint = baseball.getHint(computerNumbers, userNumbers);
        assertThat(hint).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("3스트라이크")
    void threeStrike() {
        Baseball baseball = new Baseball();
        List<Integer> computerNumbers = List.of(7, 1, 3);
        List<Integer> userNumbers = List.of(7, 1, 3);
        String hint = baseball.getHint(computerNumbers, userNumbers);
        assertThat(hint).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("낫싱")
    void nothing() {
        Baseball baseball = new Baseball();
        List<Integer> computerNumbers = List.of(7, 1, 3);
        List<Integer> userNumbers = List.of(2, 4, 5);
        String hint = baseball.getHint(computerNumbers, userNumbers);
        assertThat(hint).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("2볼 1스트라이크")
    void twoBallAndStrike() {
        Baseball baseball = new Baseball();
        List<Integer> computerNumbers = List.of(7, 1, 3);
        List<Integer> userNumbers = List.of(7, 3, 1);
        String hint = baseball.getHint(computerNumbers, userNumbers);
        assertThat(hint).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("2스트라이크")
    void twoStrike() {
        Baseball baseball = new Baseball();
        List<Integer> computerNumbers = List.of(7, 1, 3);
        List<Integer> userNumbers = List.of(7, 1, 5);
        String hint = baseball.getHint(computerNumbers, userNumbers);
        assertThat(hint).isEqualTo("2스트라이크");
    }

    @Test
    void 게임_종료_안내() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "1", "589", "1", "456", "2");
                    assertThat(output()).contains("3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료", "3스트라이크",
                            "게임 종료", "애플리케이션을 종료합니다.");
                },
                1, 3, 5, 5, 8, 9, 4, 5, 6
        );
    }

    @Test
    @DisplayName("1보다 작은 수가 포함")
    void inZeroException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("1자리의 수 입력")
    void OneLengthNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("2자리의 수 입력")
    void twoLengthNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("4자리의 수 입력")
    void fourLengthNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("1보다 작은 중복된 수")
    void lessThanOneAndDuplicationNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("중복된 수1")
    void DuplicationNumber1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("중복된 수2")
    void DuplicationNumber2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("121"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("중복된 수3")
    void DuplicationNumber3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("211"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("중복된 수4")
    void DuplicationNumber4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("소수 입력")
    void InputFloatNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1.11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("0 입력")
    void inputZero() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("음수 입력")
    void InputNegativeNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("한글 입력")
    void inputKorean() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㅂ"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("특수문자 입력")
    void inputEscape() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("@"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("공백 입력")
    void inputSpace() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("게임 옵션 범위 밖 숫자 입력1")
    void OutRangeGameOption() {
        assertThatThrownBy(() ->
                assertRandomNumberInRangeTest(() -> run("123", "3"),
                        1, 2, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 옵션 범위 밖 숫자 입력2")
    void OutRangeGameOption2() {
        assertThatThrownBy(() ->
                assertRandomNumberInRangeTest(() -> run("123", "-1"),
                        1, 2, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 옵션 범위 밖 숫자 입력3")
    void OutRangeGameOption3() {
        assertThatThrownBy(() ->
                assertRandomNumberInRangeTest(() -> run("123", "10"),
                        1, 2, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 옵션 범위 영어 입력")
    void GameOptionInputEnglish() {
        assertThatThrownBy(() ->
                assertRandomNumberInRangeTest(() -> run("123", "q"),
                        1, 2, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 옵션 범위 한글 입력")
    void GameOptionInputKorean() {
        assertThatThrownBy(() ->
                assertRandomNumberInRangeTest(() -> run("123", "ㅂ"),
                        1, 2, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 옵션 특수문자 입력")
    void GameOptionInputEscape() {
        assertThatThrownBy(() ->
                assertRandomNumberInRangeTest(() -> run("123", "#"),
                        1, 2, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
