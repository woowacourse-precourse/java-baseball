package baseball;

import baseball.domain.Calculator;
import camp.nextstep.edu.missionutils.test.NsTest;
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

    @Test
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3  "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("  4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 볼_갯수_계산_테스트() {

        List<String> computerAnswerList = List.of("1", "2", "3");
        List<String> userAnswerList = List.of("3", "2", "1");
        Calculator calculator = new Calculator(computerAnswerList, userAnswerList);
        int ballCount = calculator.ballResult;
        assertThat(ballCount).isEqualTo(2);


    }

    @Test
    void 스트라이크_갯수_계산_테스트() {
        List<String> computerAnswerList = List.of("1", "2", "3");
        List<String> userAnswerList = List.of("1", "2", "4");
        Calculator calculator = new Calculator(computerAnswerList, userAnswerList);
        int strikeCount = calculator.strikeResult;
        assertThat(strikeCount).isEqualTo(2);

    }

    @Test
    void 볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("312", "123", "1", "798", "987", "2");
                    assertThat(output()).contains("3볼", "3스트라이크", "3볼", "3스트라이크", "게임 종료");
                },
                1, 2, 3, 9, 8, 7
        );
    }

    @Test
    void 스트라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("361", "162", "372", "362", "2");
                    assertThat(output()).contains("2스트라이크", "2스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                3, 6, 2
        );
    }

    @Test
    void 볼_스트라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("745", "743", "374", "473", "734", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "2볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                7, 3, 4
        );
    }

    @Test
    void 낫싱_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("124", "586", "415", "826", "793", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "낫싱", "낫싱", "3스트라이크", "게임 종료");
                },
                7, 9, 3
        );
    }

    @Test
    void 시스템_메세지_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("592", "925", "734", "1", "374", "592", "2");
                    assertThat(output()).isEqualTo(
                            "숫자 야구 게임을 시작합니다.\n" +
                                    "숫자를 입력해주세요 : 낫싱\n" +
                                    "숫자를 입력해주세요 : 낫싱\n" +
                                    "숫자를 입력해주세요 : 3스트라이크\n" +
                                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n" +
                                    "숫자 야구 게임을 시작합니다.\n" +
                                    "숫자를 입력해주세요 : 낫싱\n" +
                                    "숫자를 입력해주세요 : 3스트라이크\n" +
                                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                },
                7, 3, 4, 5, 9, 2
        );
    }

}
