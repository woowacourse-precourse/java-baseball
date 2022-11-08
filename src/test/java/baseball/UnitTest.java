package baseball;

import baseball.domain.ComputerNumber;
import baseball.service.JudgeGame;
import baseball.util.ValidationUtil;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class UnitTest extends NsTest {

    @Test
    void 컴퓨터_생성_세자리_난수_적정성_검토() {
        ComputerNumber computerNumber = new ComputerNumber();
        Integer hundredNumber = computerNumber.computerNumberList.get(0);
        Integer tenNumber = computerNumber.computerNumberList.get(1);
        Integer number = computerNumber.computerNumberList.get(2);

        assertThat(hundredNumber).isBetween(1, 9);
        assertThat(tenNumber).isBetween(1, 9);
        assertThat(number).isBetween(1, 9);
        assertThat(hundredNumber).isNotEqualTo(tenNumber);
        assertThat(hundredNumber).isNotEqualTo(number);
        assertThat(tenNumber).isNotEqualTo(number);
    }

    @Test
    void 스트라이크_및_볼_개수_출력값_검증() {
        List<Integer> inputNumList = new ArrayList<>();
        List<Integer> computerNumList = new ArrayList<>();

        inputNumList.add(3);
        inputNumList.add(6);
        inputNumList.add(9);

        computerNumList.add(9);
        computerNumList.add(6);
        computerNumList.add(3);

        int strikeCounter = JudgeGame.verifyStrike(inputNumList, computerNumList);
        int ballCounter = JudgeGame.verifyBall(inputNumList, computerNumList);

        assertThat(strikeCounter).isEqualTo(1);
        assertThat(ballCounter).isEqualTo(2);
    }

    @Test
    void 사용자_입력_값과_컴퓨터_생성값_간_비교() {
        List<Integer> inputNumList = new ArrayList<>();
        List<Integer> computerNumList = new ArrayList<>();

        inputNumList.add(3);
        inputNumList.add(6);
        inputNumList.add(9);

        computerNumList.add(9);
        computerNumList.add(6);
        computerNumList.add(3);

        boolean getGameResult = JudgeGame.verifyAnswer(inputNumList, computerNumList);

        assertThat(getGameResult).isEqualTo(true);
    }

    @Test
    void 첫_번째_입력값_예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 첫_번째_입력값_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 첫_번째_입력값_예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 첫_번째_입력값_예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}