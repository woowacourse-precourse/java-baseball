package baseball.player;

import org.junit.jupiter.api.Test; // @Test annotation
import org.junit.jupiter.api.BeforeEach; // @BeforeEach annotation

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;


public class UserTest {

    private User user;

    @BeforeEach
    private void createObject(){
        user = new User();
    }

    //User
    @Test
    void 유저_정상_입력_확인() {
        user.setUser("123");
        List<Integer> numbers =  user.getUserNumbers();
        assertThat(numbers).isEqualTo(Arrays.asList(1,2,3));
    }

    @Test
    void 유저_문자_입력_예외처리(){
        assertThatThrownBy(()-> user.setUser("12a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력에 1~9 사이의 숫자를 벗어나는 문자가 있습니다.");
    }

    @Test
    void 유저_0_입력_예외처리(){
        assertThatThrownBy(()-> user.setUser("012"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력에 1~9 사이의 숫자를 벗어나는 문자가 있습니다.");
    }

    @Test
    void 유저_초과_입력_예외처리(){
        assertThatThrownBy(()-> user.setUser("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자가 아닙니다.");
    }

    @Test
    void 유저_빈_문자열_예외처리(){
        assertThatThrownBy(()-> user.setUser(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자가 아닙니다.");
    }

    @Test
    void 유저_중복_입력_예외처리(){
        assertThatThrownBy(()-> user.setUser("122"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 존재합니다.");
    }

}
