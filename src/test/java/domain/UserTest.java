package domain;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import constant.Messages;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.Year;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest{
    @Test
    void 숫자외_문자_입력시_예외_처리() {
        User user = new User();
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> user.input());

        assertEquals(exception.getMessage(), Messages.wrongInput);
    }

    @Test
    void 입력_길이가_3이_아닌_경우_예외_처리() {
        User user = new User();

        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> user.input());
        assertEquals(exception.getMessage(), Messages.wrongInputSize);
    }

    @Test
    void 입력에_중복이_있는_경우_예외_처리() {
        User user = new User();

        String input = "112";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> user.input());
        assertEquals(exception.getMessage(), Messages.duplicateNumber);
    }

}
