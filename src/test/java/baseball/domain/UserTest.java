package baseball.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    public void 유저_야구_입력() throws Exception {
        //given
        User user = new User();
        String input = "12345";

        //when
        setSystemIn(input);
        user.inputBaseballNumber();

        //then
        assertThat(user.getBaseballNumber()).isNotBlank();
        assertThat(user.getBaseballNumber()).isEqualTo(input);
    }

    @Test
    public void 유저_재시작_선택_입력() throws Exception {
        //given
        User user = new User();
        String input = "1";

        //when
        setSystemIn(input);
        user.selectRestart();

        //then
        assertThat(user.getRestartSelection()).isNotBlank();
        assertThat(user.getRestartSelection()).isEqualTo("1");
    }

    @Test
    public void 유저_입력_유효성_검사() throws Exception {
        //given
        User validCase1 = new User();
        User validCase2 = new User();
        User invalidCase1 = new User();
        User invalidCase2 = new User();

        String validBaseballNumber = "152";
        String validSelection = "1";

        String invalid1 = "23489238947";
        String invalid2 = "5";

        //when
        setSystemIn(validBaseballNumber);
        validCase1.inputBaseballNumber();

        setSystemIn(validSelection);
        validCase2.selectRestart();

        setSystemIn(invalid1);
        invalidCase1.inputBaseballNumber();

        setSystemIn(invalid2);
        invalidCase2.selectRestart();

        //then
        assertThat(validCase1.isValidNumber()).isTrue();
        assertThat(validCase2.isValidSelection()).isTrue();
        assertThat(invalidCase1.isValidNumber()).isFalse();
        assertThat(invalidCase2.isValidSelection()).isFalse();
    }

    private void setSystemIn(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
