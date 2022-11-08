package baseball.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user = new User();

    @Test
    void inputUserAnswer() {
        List<Integer> result = List.of(1,2,3);
        String input = "123";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Integer> userNumbers = user.inputUserAnswer();
        assertEquals(userNumbers, result);
    }

    @Test
    void inputKeepPlaying_1_입력_True() {
        String input = "1";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertTrue(user.inputKeepPlaying());
    }

    @Test
    void inputKeepPlaying_2_입력_False() {
        String input = "2";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertFalse(user.inputKeepPlaying());
    }

    @Test
    void inputKeepPlaying_1과2_외_입력_Exception() {
        String input = "a";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() -> assertThatThrownBy(() -> user.inputKeepPlaying()).isInstanceOf(IllegalArgumentException.class));
    }
}