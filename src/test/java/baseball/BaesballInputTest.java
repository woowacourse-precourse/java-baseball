package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BaesballInputTest {
    private static final InputStream systemIn = System.in;
    private static ByteArrayInputStream testIn;

    BaseballInput baseballInput = new BaseballInput();

    @AfterAll
    private static void restoreSystemInput() {
        System.setIn(systemIn);
    }


    @BeforeAll
    private static void setTestIn() {
        testIn = new ByteArrayInputStream("123".getBytes());
        System.setIn(testIn);
    }

    @Test
    void 유저_입력을_받는다() {
        Baseball baseball = new Baseball();
        baseball.play();
        String input = baseballInput.getUserInput();
        assertThat(input).isNotEmpty();
        System.out.println(input);
    }
}
