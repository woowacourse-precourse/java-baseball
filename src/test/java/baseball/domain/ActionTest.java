package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ActionTest {
    @Test
    @DisplayName("생성자에 \"1\"이 입력되었을 때 객체를 생성하는지 확인")
    void constructor_with_String_1_test() {
        String normalNumber = "1";

        assertThat(new Action(normalNumber)).isInstanceOf(Action.class);
    }

    @Test
    @DisplayName("생성자에 \"2\"가 입력되었을 때 객체를 생성하는지 확인")
    void constructor_with_String_2_test() {
        String normalNumber = "2";

        assertThat(new Action(normalNumber)).isInstanceOf(Action.class);
    }

    @Test
    @DisplayName("생성자에 \"12\"가 입력되었을 때 예외를 발생시키는지 확인")
    void constructor_with_String_12_test() {
        String exceptionNumber = "12";

        assertThatThrownBy(() -> new Action(exceptionNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Action.EXCEPTION_MESSAGE_FOR_INVALID_FORM);
    }

    @Test
    @DisplayName("생성자에 \"3\"이 입력되었을 때 예외를 발생시키는지 확인")
    void constructor_with_String_3_test() {
        String exceptionNumber = "3";

        assertThatThrownBy(() -> new Action(exceptionNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Action.EXCEPTION_MESSAGE_FOR_INVALID_FORM);
    }

    @Test
    @DisplayName("isStart 메소드가 \"1\"을 가진 Action 객체를 참조하여 호출되었을 때 true를 반환하는지 확인")
    void isStart_with_String_1_test() {
        String numberAction = "1";
        Action actionOf1 = new Action(numberAction);

        boolean startAction = actionOf1.isStart();

        assertThat(startAction).isTrue();
    }

    @Test
    @DisplayName("isStart 메소드가 \"2\"를 가진 Action 객체를 참조하여 호출되었을 때 false를 반환하는지 확인")
    void isStart_with_String_2_test() {
        String numberAction = "2";
        Action actionOf2 = new Action(numberAction);

        boolean nonStartAction = actionOf2.isStart();

        assertThat(nonStartAction).isFalse();
    }
}