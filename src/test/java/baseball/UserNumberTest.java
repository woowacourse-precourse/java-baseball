package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserNumberTest {
    @Test
    void 사용자_입력_유효성_검사_1() {
        UserNumber userNumber = new UserNumber();
        String input = "123";
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        userNumber.setUserNumbers(input);

        Assertions.assertThat(numbers)
                .isEqualTo(userNumber.getUserNumbers());
    }

    @Test
    void 사용자_입력_유효성_검사_2() {
        UserNumber userNumber = new UserNumber();
        String input = "987";
        List<Integer> numbers = Arrays.asList(9, 8, 7);

        userNumber.setUserNumbers(input);

        Assertions.assertThat(numbers)
                .isEqualTo(userNumber.getUserNumbers());
    }

    @Test()
    void 사용자_입력_유효성_검사_3() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserNumber userNumber = new UserNumber();
            String input = "112";

            userNumber.setUserNumbers(input);
        });

        Assertions.assertThat(exception.getMessage())
                .isEqualTo("중복되지 않은 숫자를 입력해야 합니다.");

    }

    @Test
    void 사용자_입력_유효성_검사_4() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserNumber userNumber = new UserNumber();
            String input = "12";

            userNumber.setUserNumbers(input);
        });

        Assertions.assertThat(exception.getMessage())
                .isEqualTo("3개의 숫자를 입력해야 합니다.");
    }

    @Test
    void 사용자_입력_유효성_검사_5() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserNumber userNumber = new UserNumber();
            String input = "ㅁㅁㅁ";

            userNumber.setUserNumbers(input);
        });

        Assertions.assertThat(exception.getMessage())
                .isEqualTo("0을 제외한 1~9 사이의 숫자를 입력해야 합니다.");
    }
}