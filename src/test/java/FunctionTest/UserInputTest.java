package FunctionTest;

import baseball.Util.InputHandler;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class UserInputTest {
    @Test
    void 인풋테스트(){
        assertThat(InputHandler.getUserInput()).isEqualTo("r");
    }
}
