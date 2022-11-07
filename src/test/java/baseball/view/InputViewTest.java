package baseball.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void 숫자_야구_게임_비정상적인_입력값_처리() {
        Assertions.assertThatCode(() -> InputView.validateRequestNum(" 1 2 3 "))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateRequestNum("456"))
                .doesNotThrowAnyException();

        Assertions.assertThatThrownBy(() -> InputView.validateRequestNum("a12"));
        Assertions.assertThatThrownBy(() -> InputView.validateRequestNum("12"));
        Assertions.assertThatThrownBy(() -> InputView.validateRequestNum("1234"));
        Assertions.assertThatThrownBy(() -> InputView.validateRequestNum("120"));
        Assertions.assertThatThrownBy(() -> InputView.validateRequestNum("112"));
    }

    @Test
    void 게임_종료시_비정상적인_입력값_처리() {
        Assertions.assertThatCode(() -> InputView.validateRequestIsReGame(" 1 "))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateRequestIsReGame("1"))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateRequestIsReGame(" 2 "))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateRequestIsReGame("2"))
                .doesNotThrowAnyException();

        Assertions.assertThatThrownBy(() -> InputView.validateRequestIsReGame("3"));
        Assertions.assertThatThrownBy(() -> InputView.validateRequestIsReGame("0"));
        Assertions.assertThatThrownBy(() -> InputView.validateRequestIsReGame("a"));
        Assertions.assertThatThrownBy(() -> InputView.validateRequestIsReGame("11"));
        Assertions.assertThatThrownBy(() -> InputView.validateRequestIsReGame(""));
        Assertions.assertThatThrownBy(() -> InputView.validateRequestIsReGame(" "));
    }
}