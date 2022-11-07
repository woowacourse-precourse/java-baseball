package baseball;

import baseball.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private final User user = new User();

    @Test
    @DisplayName("유저 입력 String List 변환 테스트")
    void userInputToList() {
        final int COUNT = 3;
        user.setUserNumber("123");
        List<Integer> answer = List.of(1, 2, 3);
        for (int i = 0; i < COUNT; i++) {
            assertThat(user.getUserNumberList().get(i)).isEqualTo(answer.get(i));
        }
    }

    @Test
    @DisplayName("유저 입력에 중복이 없는지 테스트")
    void checkDuplicate() {
        String userInput = "446";
        assertThat(user.checkDuplicateNumber(userInput)).isTrue();
    }
}
