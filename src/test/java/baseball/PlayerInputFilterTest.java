package baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class PlayerInputFilterTest {

    PlayerInputFilter playerInputFilter;

    @BeforeEach
    void 변수_초기화(){
        playerInputFilter = new PlayerInputFilter();
    }

    @Test
    void 숫자_아닐때_예외처리(){
        assertThatThrownBy(() -> playerInputFilter.checkIfNotNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어는 숫자를 입력해야합니다.");
    }

    @Test
    void 세자리_아닐때_예외처리(){
        assertThatThrownBy(() -> playerInputFilter.checkIfNotThreeDigit("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어는 세 자리 숫자를 입력해야 합니다.");
    }

    @Test
    void 입력에_0있으면_예외처리(){
        assertThatThrownBy(() -> playerInputFilter.checkIfContainsZero("103"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어의 입력숫자는 0이 아니어야 합니다.");
    }

    @Test
    void 입력에_같은수_있으면_예외처리(){
        assertThatThrownBy(() -> playerInputFilter.checkIfContainsMultiNumbers("112"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어의 입력숫자는 서로 달라야 합니다.");
    }

    @Test
    void 입력이_문제없을때_3자리_배열_리턴(){
        assertThat(playerInputFilter.saveInput("123")).isEqualTo(new int[]{1, 2, 3});
    }
}
