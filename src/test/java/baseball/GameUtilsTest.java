package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameUtilsTest {

    @DisplayName("입력받은 문자열을 정수 리스트로 반환할 수 있다.")
    @Test
    void 사용자_입력() {
        System.setIn(generateUserInput("135"));
        List<Integer> input = GameUtils.getPlayerInputNum();
        assertThat(input).isEqualTo(Arrays.asList(1,3,5));
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
