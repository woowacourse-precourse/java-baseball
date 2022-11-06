package baseball.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

    @Test
    void 입력_값이_1에서9가_아닌_경우 () throws Exception {
        //given
        String input = "1a0";
        //when

        //then
        assertThatThrownBy(() -> InputException.inputCheckDuringGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값을 입력하여 게임을 종료합니다.");
    }

    @Test
    void 입력_값에_중복되는_숫자가_있는_경우 () throws Exception {
        //given
        String input = "119";
        //when

        //then
        assertThatThrownBy(() -> InputException.inputCheckDuringGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값을 입력하여 게임을 종료합니다.");
    }

    @Test
    void 입력_값이_3자리가_아닌_경우 () throws Exception {
        //given
        String input = "1193";
        //when

        //then
        assertThatThrownBy(() -> InputException.inputCheckDuringGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값을 입력하여 게임을 종료합니다.");
    }

    @Test
    void 입력_값이_1또는2가_아닌_경우 () throws Exception {
        //given
        String input = "4";
        //when

        //then
        assertThatThrownBy(() -> InputException.inputCheckAfterGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값을 입력하여 게임을 종료합니다.");
    }
}
