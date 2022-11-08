package member;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

class UserTest extends NsTest {

    @Test
    void 사용자가_범위_외의_숫자를_입력했을_때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자가_요구한_자릿수_미만으로_입력했을_때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자가_요구한_자릿수를_초과하여_입력했을_때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자의_수가_초기화되는지_확인() {
        //given
        User user = new User();
        user.setNumbers("123");
        //when
        user.clearNumbers();
        //then
        assertThat(user.getNumbers()).isEqualTo(Collections.emptyList());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}