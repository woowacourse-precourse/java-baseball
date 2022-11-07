package baseball.user;

import baseball.valid.Valid;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("유저 클래스 테스트")
class UserTest {

    @DisplayName("예외: 유저한테 입력 받기")
    @Test
    void 유저한테_정상적인_값_입력받기(){
        int result = 123;
        String test = "123";
        assertThat(Valid.userInput(test)).isEqualTo(result);
    }
    @DisplayName("예외: 유저_입력값_길이가_3이_아닐때_예외_발생 메시지")
    @Test
    void 유저_입력값_길이가_3이_아닐때_예외_발생(){
        String input = "12";
        assertThatThrownBy(() -> Valid.OutOfRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자의 범위를 벗어났습니다.");
    }
    @DisplayName("예외: 유저_입력값_정수가_아닐때_예외_발생 메시지")
    @Test
    void 유저_입력값_정수가_아닐때_예외_발생(){
        Character input = 'a';
        assertThatThrownBy(() -> Valid.NotMatch(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 값이 정수가 아닙니다.");
    }
    @DisplayName("예외: 유저_입력값_중복된_값_존재시_예외_발생 메시지")
    @Test
    void 유저_입력값_중복된_값_존재시_예외_발생(){
        Character input = '1';
        List<Character> list = new ArrayList<>(List.of('1','2'));
        assertThatThrownBy(() -> Valid.checkOverlap(list, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 들어 왔습니다.");
    }

}
