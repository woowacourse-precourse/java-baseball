package baseball.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    @DisplayName("사용자에게 입력받은 값으로 List를 잘 생성하는지 테스트")
    void UserNumberListTest() {
        // given
        String userInputNumber = "367";
        User user = new User();

        // when
        user.setUserNumberList(userInputNumber);

        // then
        assertEquals(List.of(3, 6, 7), user.getUserNumberList());
    }
}
