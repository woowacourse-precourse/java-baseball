package baseball;

import baseball.Domain.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @Test
    void 예외_테스트_길이() {
        String answer = "1234";
        User user = new User();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> user.checkSize(answer))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중복() {
        String answer = "222";
        User user = new User();
        Integer[] userArr = {1, 2, 3};
        ArrayList<Integer> userList = new ArrayList<>(Arrays.asList(userArr));
        user.userNumber = userList;

        assertSimpleTest(() ->
                assertThatThrownBy(() -> user.addUserNumber(answer))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자범위() {
        String answer = "018";
        User user = new User();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> user.checkDigit(answer))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_재시작_숫자() {
        User user = new User();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> user.verifyFinishNumber("3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
