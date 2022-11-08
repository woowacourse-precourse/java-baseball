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

    @Test
    void 중복된_번호_존재하면_에러() {
        User user = new User();
        List<Integer> nums = List.of(1,2,2);
        assertThatThrownBy(() -> user.createNums(nums, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 번호가 있습니다.");
    }
}