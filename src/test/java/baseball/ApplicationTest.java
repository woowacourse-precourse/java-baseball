package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    Application application = new Application();
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 프로그램_시작_출력_테스트() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method printProgramStart = Application.class.getDeclaredMethod("printProgramStart");
        printProgramStart.setAccessible(true);
        
        printProgramStart.invoke(application);

        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    void 게임종료_출력_테스트() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method printGameEnd = Application.class.getDeclaredMethod("printGameEnd");
        printGameEnd.setAccessible(true);

        printGameEnd.invoke(application);

        assertThat(output()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    void 정답값_유효성_테스트1_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method isAnswerNumberValid = Application.class.getDeclaredMethod("isAnswerNumberValid", int.class);
        isAnswerNumberValid.setAccessible(true);

        boolean isAnswerValid = (boolean) isAnswerNumberValid.invoke(application,123);

        assertThat(isAnswerValid).isEqualTo(true);
    }

    @Test
    void 정답값_유효성_테스트2_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method isAnswerNumberValid = Application.class.getDeclaredMethod("isAnswerNumberValid", int.class);
        isAnswerNumberValid.setAccessible(true);

        boolean isAnswerValid = (boolean) isAnswerNumberValid.invoke(application,402);

        assertThat(isAnswerValid).isEqualTo(false);
    }

    @Test
    void 정답값_유효성_테스트3_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method isAnswerNumberValid = Application.class.getDeclaredMethod("isAnswerNumberValid", int.class);
        isAnswerNumberValid.setAccessible(true);

        boolean isAnswerValid = (boolean) isAnswerNumberValid.invoke(application,383);

        assertThat(isAnswerValid).isEqualTo(false);
    }

    @Test
    void 랜덤_숫자_생성_테스트_type() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method makeAnswerNumber = Application.class.getDeclaredMethod("makeAnswerNumber");
        makeAnswerNumber.setAccessible(true);

        assertThat(makeAnswerNumber.invoke(application)).isInstanceOf(List.class);
    }

    @Test
    void 입력값_유효성_테스트1_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method method = Application.class.getDeclaredMethod("isInputValid", String.class);
        method.setAccessible(true);

        boolean inputValidity = (boolean) method.invoke(application,"156");

        assertThat(inputValidity).isEqualTo(true);
    }

    @Test
    void 입력값_유효성_테스트2_except() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method method = Application.class.getDeclaredMethod("isInputValid", String.class);
        method.setAccessible(true);

        InvocationTargetException exception = assertThrows(InvocationTargetException.class,
                ()-> method.invoke(application, "1234"));

        assertThat(exception.getCause().getMessage()).isEqualTo("제한범위를 벗어나는 값을 입력했습니다.");
    }

    @Test
    void 입력값_유효성_테스트3_except() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method method = Application.class.getDeclaredMethod("isInputValid", String.class);
        method.setAccessible(true);

        InvocationTargetException exception = assertThrows(InvocationTargetException.class,
                ()-> method.invoke(application, "asd"));

        assertThat(exception.getCause().getMessage()).isEqualTo("정수가 아닌 값을 입력했습니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
