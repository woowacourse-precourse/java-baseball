package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    public void 사용자입력(){
        User user = new User();
        System.setIn(new ByteArrayInputStream("123".getBytes(StandardCharsets.UTF_8)));
        String input=user.getConsoleInput();
        assertThat("123").isEqualTo(input);
    }

    @Test
    public void 사용자입력_실패_케이스1(){
        User user = new User();
        System.setIn(new ByteArrayInputStream("13a".getBytes(StandardCharsets.UTF_8)));
        assertThatThrownBy(()->user.getConsoleInput()).isInstanceOf(IllegalArgumentException.class);
    }
}
