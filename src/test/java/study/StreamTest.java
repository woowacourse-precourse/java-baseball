package study;

import baseball.service.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {
    @Test
    void stream_getUserNumber_Test(){
        User user = new User();
        List<Integer> test = Arrays.asList(1,2,3);

        assertThat(test).isEqualTo(user.getUserNumber("123"));
    }
}
