package baseball;



import java.util.ArrayList;
import java.util.List;

import baseball.domain.UserBaseBall;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberExceptionTest {


    @Test
    @DisplayName("User Input 입력 길이 확인")
    void numberLengthTest() {
        final UserBaseBall userBaseBall = new UserBaseBall();
        final String userInputNumber = "123123";
        userBaseBall.setUserBallNumber(userInputNumber);
        String str = userBaseBall.getUserInput();

        Assertions.assertThat(str.length()).isEqualTo(3);
    }

    @Test
    @DisplayName("User Input 입력범위 확인")
    void numberRangeTest() {
        final UserBaseBall userBaseBall = new UserBaseBall();
        final String userInputNumber = "012";
        userBaseBall.setUserBallNumber(userInputNumber);
        String str = userBaseBall.getUserInput();
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < str.length(); i++) {
            list.add(Character.getNumericValue(str.charAt(i)));
        }

        Assertions.assertThat(list.stream()
            .allMatch(v -> v >= 1 && v <= 9)).isTrue();
    }
}
