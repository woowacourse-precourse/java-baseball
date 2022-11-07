package baseball;

import baseball.controller.InputController;
import baseball.controller.OutputController;
import baseball.model.ComNumber;
import baseball.model.UserNumber;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    OutputController outputController = new OutputController();
    ComNumber comNumber = new ComNumber();
    UserNumber userNumber = new UserNumber();
    List<Integer> com = new ArrayList<>();
    List<Integer> user = new ArrayList<>();

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
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 랜덤넘버_길이_테스트() {
        InputController inputController = new InputController();
        List<Integer> makenumber = inputController.insertComNumber();
        assertThat(makenumber.size() == 3);
    }

    @Test
    void 스트라이크1_볼1() {
        com.add(1); com.add(2); com.add(3);
        user.add(1); user.add(3); user.add(5);
        comNumber.setComnumber(com);
        userNumber.setUsernumber(user);
        int strike = outputController.getStrike(comNumber,userNumber);
        int ball = outputController.getBall(comNumber,userNumber);
        String test = outputController.numOfStrikeBall(strike,ball);
        assertThat(test).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 스트라이크3() {
        com.add(1); com.add(2); com.add(3);
        user.add(1); user.add(2); user.add(3);
        comNumber.setComnumber(com);
        userNumber.setUsernumber(user);
        int strike = outputController.getStrike(comNumber,userNumber);
        int ball = outputController.getBall(comNumber,userNumber);
        String test = outputController.numOfStrikeBall(strike,ball);
        assertThat(test).isEqualTo("3스트라이크");
    }

    @Test
    void 낫싱() {
        com.add(1); com.add(2); com.add(3);
        user.add(4); user.add(5); user.add(6);
        comNumber.setComnumber(com);
        userNumber.setUsernumber(user);
        int strike = outputController.getStrike(comNumber,userNumber);
        int ball = outputController.getBall(comNumber,userNumber);
        String test = outputController.numOfStrikeBall(strike,ball);
        assertThat(test).isEqualTo("낫싱");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
