package baseball.User.UsertTest;

import baseball.User.InputPlayer;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class InputPlayerTest {


    @Test
    @DisplayName("사용자 입력 범위 테스트")
    void InputLength() {
        InputPlayer inputPlayer = new InputPlayer();
        int[] test = inputPlayer.enterAnswer();
        List<Object> list = Arrays.asList(test);
        assertThat(4).isEqualTo(list.size());


    }
}


