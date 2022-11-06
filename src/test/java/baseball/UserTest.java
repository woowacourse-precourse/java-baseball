package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    public void 사용자입력(){
        User user = new User();
        System.setIn(new ByteArrayInputStream("123".getBytes(StandardCharsets.UTF_8)));
        String input=user.getConsoleInput();
        assertThat("123").isEqualTo(input);
    }
}
