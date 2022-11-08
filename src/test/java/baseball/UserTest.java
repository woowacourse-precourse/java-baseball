package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;


class UserTest {

    @Test
    void 올바른_입력() {
        User user = new User();
        List<Integer> nums = List.of(1,2,3);
        user.createNums(nums, 3);

        assertThat(new HashSet<>(nums)).hasSize(3);
    }
}