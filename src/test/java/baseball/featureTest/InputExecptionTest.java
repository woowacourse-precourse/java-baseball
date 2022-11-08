package baseball.featureTest;

import baseball.Application;
import baseball.InputException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class InputExecptionTest {
    @Test
    void exception_inputEmptyException(){
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputException.inputEmptyException("");
        });
    }

    @Test
    void exception_inputHasSameCharException(){
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputException.inputHasSameCharException("");
        });
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputException.inputHasSameCharException("12333");
        });
    }

    @Test
    void exception_inputNotThreeNumberException(){
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputException.inputNotThreeNumberException("");
        });
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputException.inputNotThreeNumberException("12345");
        });
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputException.inputNotThreeNumberException("1삼3");
        });
    }

    @Test
    void exception_inputNotOneOrTwoException(){
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputException.inputNotOneOrTwoException("");
        });
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputException.inputNotOneOrTwoException("123");
        });
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputException.inputNotOneOrTwoException("삼");
        });
        assertThatIllegalArgumentException().isThrownBy(()->{
            InputException.inputNotOneOrTwoException("3");
        });
    }


}
