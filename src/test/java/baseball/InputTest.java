package baseball;

import baseball.controller.InputController;
import baseball.utils.InputValidation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.List;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {
    InputController inputController = new InputController();

    @Test
    void 랜덤넘버_길이_테스트() {
        List<Integer> makenumber = inputController.insertComNumber();
        assertThat(makenumber.size() == 3);
    }

    @Test
    void 랜덤넘버_문자_테스트() {
        InputValidation inputValidation = new InputValidation();
        List<Integer> makenumber = inputController.insertComNumber();
        StringBuilder number = new StringBuilder();
        for(int i=0; i<makenumber.size(); i++) {
            number.append(makenumber.get(i));
        }
        boolean check = inputValidation.checkUsernumberDigit(number.toString());
        assertThat(check).isEqualTo(true);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}