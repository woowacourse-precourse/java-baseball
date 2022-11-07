package baseball.exception;

import baseball.exception.PlayerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PlayerExceptionTest {

    PlayerException playerException;

    @BeforeEach
    void initializeClass(){
        playerException = new PlayerException();
    }

    /*@Test
    void 숫자가_아니면_참을_반환(){
        assertThat(playerException.isNotNumber("abcd")).isEqualTo(true);
    }*/

    @Test
    void 숫자가_아니면_예외처리(){
        assertThatThrownBy(()->playerException.checkException("abcd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 1부터 9중 서로 다른 3개의 숫자여야 합니다.");
    }
    /*
    @Test
    void 세자리가_아니면_참을_반환(){
        assertThat(playerException.isNotThreeDigit("0123")).isEqualTo(true);
    }
    */
    @Test
    void 세자리가_아니면_예외처리(){
        assertThatThrownBy(()->playerException.checkException("0123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 1부터 9중 서로 다른 3개의 숫자여야 합니다.");
    }
    /*
    @Test
    void 숫자0이_있으면_참을_반환(){
        assertThat(playerException.containsZero("012")).isEqualTo(true);
    }
     */
    @Test
    void 숫자0이_있으면_예외처리(){
        assertThatThrownBy(()->playerException.checkException("012"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 1부터 9중 서로 다른 3개의 숫자여야 합니다.");
    }
    /*
    @Test
    void 같은_숫자가_있으면_참을_반환(){
        assertThat(playerException.containsSameNumber("112")).isEqualTo(true);
    }
     */
    @Test
    void 같은_숫자가_있으면_예외처리(){
        assertThatThrownBy(()->playerException.checkException("112"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 1부터 9중 서로 다른 3개의 숫자여야 합니다.");
    }
}
