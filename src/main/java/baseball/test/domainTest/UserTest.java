package baseball.test.domainTest;

import baseball.domain.Game;
import baseball.domain.User;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    void getUserAnswerTest() {
        User user = new User(123);
        List<Integer> target = List.of(1, 2, 3);
        assertThat(user.getUserAnswer()).isEqualTo(target);
    }

//    @Test
//    void validateTest() {
//        User user = new User(111);
//        List<Integer> target = List.of(1, 2, 3);
//        assertThat(user.getUserAnswer()).isEqualTo(target);
//    }
}
