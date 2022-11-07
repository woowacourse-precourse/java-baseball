package baseball;

import baseball.controller.OutputController;
import baseball.model.ComNumber;
import baseball.model.UserNumber;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {
    OutputController outputController = new OutputController();
    ComNumber comNumber = new ComNumber();
    UserNumber userNumber = new UserNumber();
    List<Integer> com = new ArrayList<>();
    List<Integer> user = new ArrayList<>();

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
}
