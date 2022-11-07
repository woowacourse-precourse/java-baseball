package baseball;

import static baseball.type.NumberType.NUMBER_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.service.UserNumberService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UserNumberTest {

    @Test
    void 정상_입력() {
        String input = "123";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Integer> userNumbers = UserNumberService.generate();

        int userNumbersSize = userNumbers.size();
        assertThat(userNumbersSize).isEqualTo(NUMBER_SIZE.getValue());
    }

    @Test
    void 숫자아닌_문자_입력() {
        String input = "2a5";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(UserNumberService::generate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복_숫자_입력() {
        String input = "226";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(UserNumberService::generate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_길이_3초과_입력() {
        String input = "2345";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(UserNumberService::generate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_길이_3미만_입력() {
        String input = "25";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(UserNumberService::generate)
                .isInstanceOf(IllegalArgumentException.class);
    }


}
