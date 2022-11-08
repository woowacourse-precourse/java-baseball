package user;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
    @Test
    void changeUserInputToList_문자열을_배열로_올바르게_변환하는지_검증() {
        String userInput = "123";
        List<Integer> userInputToList = List.of(1, 2, 3);

        assertThat(UserInput.changeUserInputToList(userInput)).isEqualTo(userInputToList);
    }

    @Test
    void isRetry_1은재시작_2는게임종료() {
        assertThat(UserInput.isRetry("1")).isTrue();
        assertThat(UserInput.isRetry("2")).isFalse();
    }
}