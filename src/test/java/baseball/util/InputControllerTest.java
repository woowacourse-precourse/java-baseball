package baseball.util;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputControllerTest {

    @Test
    void getOneNumber_메소드는_1개의_숫자_입력시_Integer로_파싱되어_반환() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(InputController.getOneNumber()).isEqualTo(1);
    }

    @Test()
    void getOneNumber_메소드는_숫자가_아닌_입력시_IllegalArgumentException_발생() {
        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(InputController::getOneNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getEachNumber_메소드는_숫자_입력시_각_자리수가_Integer로_파싱되어_리스트로_반환() {
        String input = "12345";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Integer> result = InputController.getEachNumber(input.length());
        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(2);
        assertThat(result.get(2)).isEqualTo(3);
        assertThat(result.get(3)).isEqualTo(4);
        assertThat(result.get(4)).isEqualTo(5);
    }

    @Test()
    void getEachNumber_메소드는_숫자가_아닌_입력시_IllegalArgumentException_발생() {
        String input = "12a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> InputController.getEachNumber(input.length()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test()
    void getEachNumber_메소드는_length와_다른_길이의_입력시_IllegalArgumentException_발생() {
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> InputController.getEachNumber(3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
