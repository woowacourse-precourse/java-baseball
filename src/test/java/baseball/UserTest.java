package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import baseball.model.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UserTest extends NsTest {

    @Test
    void 기능1_사용자_값_입력_테스트() {
        User user = new User();
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(user.ask()).isEqualTo(123);
    }

    @Test
    void 기능2_입력_유효성_검사_테스트(){
        User user = new User();
        String input = "223";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(IllegalArgumentException.class, () -> {
            user.ask();
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
    
}