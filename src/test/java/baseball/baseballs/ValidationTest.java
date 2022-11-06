package baseball.baseballs;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationTest {

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

    @ParameterizedTest
    @ValueSource(strings = {"abc", "ab3", "a3b", "3ab", "a23", "2a3", "23a", "가12", "가나3", "가나다", " a ","   "})
    @DisplayName("1~9 이외의 문자가 포함될 경우 IllegalArgumentException 발생")
    public void test3(String input) throws Exception {
        //given
        String userInput = input;
        //when
        //then
        assertThatThrownBy(() -> {
            Baseballs.of(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "112", "121", "211"})
    @DisplayName("입력값 중 내부 중복이 있는 경우 IllegalArgumentException 발생")
    public void test4(String input) throws Exception {
        //given
        String userInput = input;
        //when
        //then
        assertThatThrownBy(() -> {
            Baseballs.of(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "987", "158", "231"})
    @DisplayName("정상적인 입력 시 Baseballs가 정상적으로 생성되는지 확인")
    public void test5(String input) throws Exception {
        //given
        String userInput = input;
        //when
        Baseballs baseballs = Baseballs.of(userInput);
        //then
        assertThat(baseballs).isInstanceOf(Baseballs.class);
    }
}
