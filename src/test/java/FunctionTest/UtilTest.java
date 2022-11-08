package FunctionTest;

import baseball.Util.InputValidator;
import static org.assertj.core.api.Assertions.*;

import baseball.Util.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

public class UtilTest {
    @Test
    void 세자리이상_입력(){
        boolean result = InputValidator.validate("321");
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 난수생성확인(){
        System.out.println(RandomNumberGenerator.generateNumbers());
    }



}
