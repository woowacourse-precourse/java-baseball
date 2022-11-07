package baseball;

import baseball.domain.User;
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
                assertThatThrownBy(() -> user.userNumberLength(answer))
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
                assertThatThrownBy(() -> user.userNumberSameCheck(answer))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_재시작_숫자() {
        User user = new User();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> user.finishNumber("3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}