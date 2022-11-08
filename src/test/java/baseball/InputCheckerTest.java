package baseball;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputCheckerTest {
    InputChecker inputChecker;
    @BeforeEach
    void setup(){
        inputChecker=new InputChecker();
    }
    @Test
    void 예외_테스트_입력길이_오류(){
        assertThatThrownBy(() -> inputChecker.checkInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_정수외의_입력(){
        assertThatThrownBy(() -> inputChecker.checkInput("1아3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputChecker.checkInput("-123"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 예외_테스트_중복발생(){
        assertThatThrownBy(() -> inputChecker.checkInput("122"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}