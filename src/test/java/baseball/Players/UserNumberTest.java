package baseball.Players;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class UserNumberTest {

    @Test
    void getNumberList_InvalidInput_ExceptionThrown() {
        String input = "1111";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new UserNumber()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리의 숫자를 입력해주세요(ex. 123)");
    }

    @Test
    void getNumberList_ValidInput_ReturnList() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        UserNumber userNumber = new UserNumber();
        List<Integer> userNumbers = userNumber.getNumberList();
        assertThat(userNumbers).isEqualTo(Arrays.asList(1, 2, 3));
    }
}