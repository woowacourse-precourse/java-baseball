package baseball.player;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Application;
import baseball.Validation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class UserTest extends NsTest {

    User user = new User(new Validation());

    @Test
    public void int가_아닌_string을_입력_받았을때() throws Exception {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12우"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}