package baseball;

import static baseball.constant.Finish.EXIT;
import static baseball.constant.Finish.RESTART;
import static baseball.constant.Finish.getFinishByCode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ViewTest {

    View view;

    @BeforeEach
    public void beforeEach() {
        view = new ConsoleView(new InputControllerImp());
    }

    @Test
    void 힌트가_0볼_0스트라이크인경우_낫싱() {
        Hint hint = Hint.builder().strike(0).ball(0).build();
        assertHint(hint, "낫싱");
    }

    @Test
    void 힌트가_0볼_n스트라이크인경우_n스트라이크() {
        Hint hint1 = Hint.builder().strike(2).build();
        Hint hint2 = Hint.builder().strike(2).build();

        assertHint(hint1, "2스트라이크");
        assertHint(hint2, "2스트라이크");
    }

    @Test
    void 힌트가_n볼_0스트라이크인경우_n볼() {
        Hint hint1 = Hint.builder().ball(2).build();
        Hint hint2 = Hint.builder().ball(3).build();

        assertHint(hint1, "2볼");
        assertHint(hint2, "3볼");
    }

    @Test
    void 힌트가_n볼_m스트라이크인경우_n볼_m스트라이크() {
        Hint hint1 = Hint.builder().strike(1).ball(1).build();
        Hint hint2 = Hint.builder().strike(1).ball(2).build();

        assertHint(hint1, "1볼 1스트라이크");
        assertHint(hint2, "2볼 1스트라이크");
    }


    @Test
    void 재시작여부입력은_1혹은_2여야함() {
        // given
        String userInput1 = "1";
        String userInput2 = "2";
        String userInput3 = "3";
        String userInput4 = "12";
        String userInput5 = "0";
        String userInput6 = "01";

        assertThat(getFinishByCode(userInput1)).isEqualTo(RESTART);
        assertThat(getFinishByCode(userInput2)).isEqualTo(EXIT);
        assertException(userInput3);
        assertException(userInput4);
        assertException(userInput5);
        assertException(userInput6);
    }

    private void assertException(String userInput) {
        assertThatThrownBy(() -> getFinishByCode(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Method testConvertHint() {
        Method method = null;
        try {
            method = view.getClass().getDeclaredMethod("convertHint", Hint.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        assert method != null;
        method.setAccessible(true);
        return method;
    }

    private void assertHint(Hint hint, String expectedMessage) {
        Method method = testConvertHint();
        try {
            String hintMessage = (String) method.invoke(view, hint);
            assertThat(hintMessage).isEqualTo(expectedMessage);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
