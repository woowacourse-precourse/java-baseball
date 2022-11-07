package baseball.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void 유저_야구_입력받기() {
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
    void 유저_선택_입력받기() {
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
    void 유저_입력_후_검증() {
        //given
        User validCase1 = new User();
        User validCase2 = new User();
        User invalidCase1 = new User();
        User invalidCase2 = new User();

        String validBaseballNumber = "194";
        String validSelection = "2";

        String invalid1 = "12412048294789331452352352";
        String invalid2 = "3";

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

    public static void setSystemIn(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}