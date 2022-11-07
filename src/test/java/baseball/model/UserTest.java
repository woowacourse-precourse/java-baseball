package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @Test
    void setExpectedNumberOfUser_메서드를_여러번_호출했을때_잘_저장되는지_확인() {
        User user = new User();
        user.setExpectedNumberOfUser("123");
        user.setExpectedNumberOfUser("456");
        user.setExpectedNumberOfUser("987");

        assertThat(user.getExpectedNumberOfUser()).containsExactly(9, 8, 7);

        user.setExpectedNumberOfUser("185");

        assertThat(user.getExpectedNumberOfUser()).containsExactly(1, 8, 5);
    }
}
