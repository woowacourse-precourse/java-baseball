package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballsTest {

    @Test
    @DisplayName("빈 입력이 주어질 경우 IllegalArgumentException 발생")
    public void test1() throws Exception{
        //given
        String userInput = "";
        //when
        //then
        assertThatThrownBy(() -> {
            Baseballs.of(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
