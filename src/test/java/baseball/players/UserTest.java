package baseball.players;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.*;


class UserTest {
    User user;

    @ParameterizedTest
    @ValueSource(strings = {"12"})
    public void 유저의_숫자_생성시_숫자를_3개를_입력하지_않았을_때_예외처리(String input) throws Exception {
        User user = new User();
        assertThatThrownBy(() -> {
            user.checkError(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12a"})
    public void 유저의_숫자_생성시_문자가_들어갈_경우_예외처리(String input) throws Exception {
        User user = new User();
        assertThatThrownBy(() -> {
            user.checkError(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"112"})
    public void 중복된_수를_입력했을_때_예외처리(String input) throws Exception {
        User user1 = new User();
        assertThatThrownBy(() -> {
            user1.checkError(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}