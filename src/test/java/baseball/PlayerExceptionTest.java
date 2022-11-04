package baseball;

import baseball.exception.PlayerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerExceptionTest {

    PlayerException playerException;

    @BeforeEach
    void initializeClass(){
        playerException = new PlayerException();
    }

    @Test
    void 숫자가_아니면_참을_반환(){
        assertThat(playerException.isNotNumber("abcd")).isEqualTo(true);
    }

    @Test
    void 숫자가_아니면_예외처리(){
        assertThatThrownBy(playerException.noNumberException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값은 숫자여야 합니다. ");
    }

    @Test
    void 세자리가_아니면_참을_반환(){
        assertThat(playerException.isNotThreeDigit("0123")).isEqualTo(true);
    }

    @Test
    void 세자리가_아니면_예외처리(){
        assertThatThrownBy(playerException.notThreeDigitException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값은 세 자리여야 합니다. ");
    }

    @Test
    void 세자리가_아니면_참을_반환(){
        assertThat(playerException.containsZero("012")).isEqualTo(true);
    }

    @Test
    void 세자리가_아니면_예외처리(){
        assertThatThrownBy(playerException.containsZeroException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값에 0이 없어야 합니다. ");
    }

    @Test
    void 같은_숫자가_있으면_참을_반환(){
        assertThat(playerException.containsSameNumber("112")).isEqualTo(true);
    }

    @Test
    void 같은_숫자가_있으면_예외처리(){
        assertThatThrownBy(playerException.containsSameNumberException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값이 서로 다른 숫자여야 합니다. ");
    }
}
