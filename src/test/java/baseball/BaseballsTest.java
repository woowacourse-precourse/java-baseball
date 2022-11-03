package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234", "123456789", "0123456789"," 2"})
    @DisplayName("입력의 길이가 3이 아닌 경우 IllegalArgumentException 발생")
    public void test2(String input) throws Exception {
        //given
        String userInput = input;
        //when
        //then
        assertThatThrownBy(() -> {
            Baseballs.of(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
