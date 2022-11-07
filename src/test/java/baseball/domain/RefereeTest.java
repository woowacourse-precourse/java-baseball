package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    @Test
    void 사용자_입력_검증() throws IllegalArgumentException {
        List<Integer> userNumbers = Arrays.asList(1, 2, 3);
        String validString = "456";
        String invalidString1 = "123";
        String invalidString2 = "113";
        String invalidString3 = "1234";
        String invalidString4 = "ㅁㄴㅇ";

        Assertions.assertThat(Referee.validateUserInput(validString, userNumbers)).isEqualTo(true);
        assertThatThrownBy(() -> Referee.validateUserInput(invalidString1, userNumbers)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Referee.validateUserInput(invalidString2, userNumbers)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Referee.validateUserInput(invalidString3, userNumbers)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Referee.validateUserInput(invalidString4, userNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 낫싱_검증(){
        Assertions.assertThat(Referee.checkNothing(0,0)).isEqualTo(true);
        Assertions.assertThat(Referee.checkNothing(1,1)).isEqualTo(false);
    }

}
