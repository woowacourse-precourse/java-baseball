package game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CheckInputTest {
    @Test
    void 종료시_입력값_확인(){
        CheckInput checkInput = new CheckInput();
        assertThatThrownBy(() -> checkInput.checkInput("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
