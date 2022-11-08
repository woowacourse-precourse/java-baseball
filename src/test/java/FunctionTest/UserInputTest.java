package FunctionTest;

import baseball.UserInput;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class UserInputTest {
    UserInput userInput = new UserInput();
    @Test
    void 인풋테스트(){
        assertThat(userInput.run()).isEqualTo("r");
    }
}
