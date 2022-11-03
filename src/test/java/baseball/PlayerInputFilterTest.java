package baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;
public class PlayerInputFilterTest {

    PlayerInputFilter playerInputFilter;

    @BeforeEach
    void 변수_초기화(){
        playerInputFilter = new PlayerInputFilter();
    }

    @Test
    void 입력값이_문자열로_리턴(){
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String result = playerInputFilter.getInput();
        assertThat(result).isEqualTo(input);
    }

    @Test
    void 숫자가_아니면_참(){
        assertThat(playerInputFilter.isNotNumber("abc")).isTrue();
    }

    @Test
    void 숫자만_있으면_거짓(){
        assertThat(playerInputFilter.isNotNumber("1234")).isFalse();
    }

    @Test
    void 숫자가_아닐때_예외처리(){
        assertThatThrownBy(() -> playerInputFilter.noNumberException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값이 숫자가 아닙니다.");
    }

    @Test
    void 세자리가_아니면_참(){
        assertThat(playerInputFilter.isNotThreeDigit("0123")).isTrue();
    }

    @Test
   void 세_자리면_거짓(){
        assertThat(playerInputFilter.isNotThreeDigit("012")).isFalse();
    }

    @Test
    void 세_자리가_아니면_예외처리(){
        assertThatThrownBy(() -> playerInputFilter.notThreeDigitException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값은 세자리 숫자여야 합니다.");
    }

    @Test
    void 숫자0_있으면_참(){
        assertThat(playerInputFilter.containsZero("012")).isTrue();
    }

    @Test
    void 숫자0_없으면_거짓(){
        assertThat(playerInputFilter.containsZero("122")).isFalse();
    }

    @Test
    void 숫자0_있으면_예외처리(){
        assertThatThrownBy(() -> playerInputFilter.containsZeroException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 문자열에 0이 있으면 안됩니다.");
    }

    @Test
    void 같은_숫자가_있으면_참(){
        assertThat(playerInputFilter.containsSameNumber("122")).isTrue();
    }

    @Test
    void 모두_다른_숫자면_거짓(){
        assertThat(playerInputFilter.containsSameNumber("123")).isFalse();
    }

    @Test
    void 같은_숫자가_있으면_예외처리(){
        assertThatThrownBy(() -> playerInputFilter.containsSameNumberException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    void 문자열_배열로_반환(){
        assertThat(playerInputFilter.convertNumbersToArray("123")).isEqualTo(new int[]{1, 2, 3});
    }
}
