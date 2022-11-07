package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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

    @Test
    void wrongInputValueCheck_false_return_테스트_같은_수가_존재하는_경우(){
        String userInput = "121";
        init();
        boolean funcResult = wrongInputValueCheck(userInput);

        assertThat(funcResult).isEqualTo(false);
    }

    @Test
    void wrongInputValueCheck_false_return_테스트_0이_존재하는_경우(){
        String userInput = "102";
        init();
        boolean funcResult = wrongInputValueCheck(userInput);

        assertThat(funcResult).isEqualTo(false);
    }

    @Test
    void wrongInputValueCheck_true_return_테스트(){
        String userInput = "123";
        init();
        boolean funcResult = wrongInputValueCheck(userInput);

        assertThat(funcResult).isEqualTo(true);
    }

    @Test
    void StrikeBallResultPrintTest_스트라이크가_3이고_볼이_0인_경우(){
        int strike = 3, ball = 0;
        init();
        int funcResult = StrikeBallResultPrint(strike, ball);
        String outputResult = output();

        assertThat(funcResult).isEqualTo(1);
        assertThat(outputResult).isEqualTo("3스트라이크");
    }

    @Test
    void StrikeBallResultPrintTest_스트라이크가_0이_아니고_볼이_0인_경우() {
        int strike = 2, ball = 0;
        init();
        int funcResult = StrikeBallResultPrint(strike, ball);
        String outputResult = output();

        assertThat(funcResult).isEqualTo(0);
        assertThat(outputResult).isEqualTo("2스트라이크");
    }

    @Test
    void StrikeBallResultPrintTest_스트라이크가_0이고_볼이_0이_아닌_경우(){
        int strike = 0, ball = 1;
        init();
        int funcResult = StrikeBallResultPrint(strike, ball);
        String outputResult = output();

        assertThat(funcResult).isEqualTo(0);
        assertThat(outputResult).isEqualTo("1볼");
    }

    @Test
    void StrikeBallResultPrintTest_스트라이크가_0이고_볼이_0인_경우(){
        int strike = 0, ball = 0;
        init();
        int funcResult = StrikeBallResultPrint(strike, ball);
        String outputResult = output();

        assertThat(funcResult).isEqualTo(0);
        assertThat(outputResult).isEqualTo("낫싱");
    }

    @Test
    void StrikeBallResultPrintTest_스트라이크가_0이_아니고_볼이_0이_아닌_경우(){
        int strike = 2, ball = 1;
        init();
        int funcResult = StrikeBallResultPrint(strike, ball);
        String outputResult = output();

        assertThat(funcResult).isEqualTo(0);
        assertThat(outputResult).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void gameRestartCheckerTest_3스트라이크일_경우(){
        int ThreeStrikeCheck = 1;
        init();
        int funcResult = gameRestartChecker(ThreeStrikeCheck);
        String outputResult = output();

        assertThat(funcResult).isEqualTo(1);
        assertThat(outputResult).isEqualTo("3개의 숫자를 모두 맞히셧습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Test
    void gameRestartCheckerTest_3스트라이크가_아닐_경우(){
        int ThreeStrikeCheck = 0;
        init();
        int funcResult = gameRestartChecker(ThreeStrikeCheck);

        assertThat(funcResult).isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
