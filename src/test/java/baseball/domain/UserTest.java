package baseball.domain;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void 사용자_숫자_생성() {
        InputStream inFirst = generateUserInput("123");
        System.setIn(inFirst);

        List<Integer> rightInput = Arrays.asList(1, 2, 3);

        Assertions.assertThat(User.getNumbers()).isEqualTo(rightInput);
    }

}
