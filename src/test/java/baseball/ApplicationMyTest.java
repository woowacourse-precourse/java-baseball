package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationMyTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    public final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    private String output() {
        return captor.toString().trim();
    }

    private void input(String str) {
        System.setIn(new ByteArrayInputStream(str.getBytes()));
    }

    private Method getPrivateMethod(String methodName, Class<?>... parameters) throws NoSuchMethodException {
        Method method = Application.class.getDeclaredMethod(methodName, parameters);
        method.setAccessible(true);
        return method;
    }

    @Test
    @DisplayName("[게임 시작 문구 출력]")
    void printStartGameSentence_게임_시작_문구_출력() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method printStartGameSentenceMethod = getPrivateMethod("printStartGameSentence");
        printStartGameSentenceMethod.invoke(Application.class);

        assertThat(output()).contains("숫자 야구 게임을 시작합니다.");
    }

    @Test
    @DisplayName("[컴퓨터의 3자리 숫자 생성] 3자리")
    void getComputerPick_컴퓨터의_3자리_숫자_생성() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getComputerPickMethod = getPrivateMethod("getComputerPick");
        Object object = getComputerPickMethod.invoke(Application.class);
        ArrayList<Integer> numbers = (ArrayList<Integer>) object;

        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("[컴퓨터의 3자리 숫자 생성] 서로 다른 3자리")
    void getComputerPick_서로_다른_3자리_숫자_생성() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getComputerPickMethod = getPrivateMethod("getComputerPick");
        Object object = getComputerPickMethod.invoke(Application.class);
        ArrayList<Integer> numberList = (ArrayList<Integer>) object;
        HashSet<Integer> numberSet = new HashSet<>(numberList);

        assertThat(numberSet.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("[사용자로부터 3자리 숫자 입력 받기] 3자리")
    void getUserPick_사용자로부터_3자리_숫자_입력_받기() throws NoSuchMethodException {
        Method getUserPickMethod = getPrivateMethod("getUserPick");
        input("123");

        assertDoesNotThrow(() -> getUserPickMethod.invoke(Application.class));
    }

    @Test
    @DisplayName("[사용자로부터 3자리 숫자 입력 받기] 4자리 예외")
    void getUserPick_사용자로부터_3자리_숫자_입력_받기_4자리_예외() throws NoSuchMethodException {
        Method getUserPickMethod = getPrivateMethod("getUserPick");
        input("1234");
        Class<?> exceptionClass = null;

        try {
            getUserPickMethod.invoke(Application.class);
        } catch (IllegalAccessException ignored) {

        } catch (InvocationTargetException e) {
            exceptionClass = e.getTargetException().getClass();
        }

        assertThat(exceptionClass).isEqualTo(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[사용자로부터 3자리 숫자 입력 받기] 0 포함 예외")
    void getUserPick_사용자로부터_3자리_숫자_입력_받기_0_포함_예외() throws NoSuchMethodException {
        Method getUserPickMethod = getPrivateMethod("getUserPick");
        input("012");
        Class<?> exceptionClass = null;

        try {
            getUserPickMethod.invoke(Application.class);
        } catch (IllegalAccessException ignored) {

        } catch (InvocationTargetException e) {
            exceptionClass = e.getTargetException().getClass();
        }

        assertThat(exceptionClass).isEqualTo(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[사용자로부터 3자리 숫자 입력 받기] 중복 숫자 예외")
    void getUserPick_사용자로부터_3자리_숫자_입력_받기_중복_숫자_예외() throws NoSuchMethodException {
        Method getUserPickMethod = getPrivateMethod("getUserPick");
        input("112");
        Class<?> exceptionClass = null;

        try {
            getUserPickMethod.invoke(Application.class);
        } catch (IllegalAccessException ignored) {

        } catch (InvocationTargetException e) {
            exceptionClass = e.getTargetException().getClass();
        }

        assertThat(exceptionClass).isEqualTo(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[컴퓨터와 사용자의 숫자를 서로 비교]")
    void getGameResults_컴퓨터와_사용자의_숫자를_서로_비교() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getGameResultsMethod = getPrivateMethod("getGameResults", List.class, List.class);

        List<Integer> strike3 = (List<Integer>) getGameResultsMethod.invoke(Application.class, Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        List<Integer> ball2Strike1 = (List<Integer>) getGameResultsMethod.invoke(Application.class, Arrays.asList(1, 3, 2), Arrays.asList(1, 2, 3));
        List<Integer> ball3 = (List<Integer>) getGameResultsMethod.invoke(Application.class, Arrays.asList(3, 1, 2), Arrays.asList(1, 2, 3));
        List<Integer> nothing = (List<Integer>) getGameResultsMethod.invoke(Application.class, Arrays.asList(4, 5, 6), Arrays.asList(1, 2, 3));

        assertThat(strike3).containsExactly(0, 3);
        assertThat(ball2Strike1).containsExactly(2, 1);
        assertThat(ball3).containsExactly(3, 0);
        assertThat(nothing).containsExactly(0, 0);
    }

    @Test
    @DisplayName("[게임 결과 출력]")
    void interpretGameResults_게임_결과_출력() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method interpretGameResultsMethod = getPrivateMethod("interpretGameResults", List.class);

        interpretGameResultsMethod.invoke(Application.class, Arrays.asList(0, 0));
        assertThat(output()).contains("낫싱");
        interpretGameResultsMethod.invoke(Application.class, Arrays.asList(1, 0));
        assertThat(output()).contains("1볼");
        interpretGameResultsMethod.invoke(Application.class, Arrays.asList(0, 1));
        assertThat(output()).contains("1스트라이크");
        interpretGameResultsMethod.invoke(Application.class, Arrays.asList(1, 1));
        assertThat(output()).contains("1볼 1스트라이크");
    }

    @Test
    @DisplayName("[게임 결과 출력] 3스트라이크")
    void isSuccess_3스트라이크_성공() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method isSuccessMethod = getPrivateMethod("isSuccess", List.class, List.class);
        isSuccessMethod.invoke(Application.class, Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));

        assertThat(output()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    @DisplayName("[사용자로부터 재시도 여부 입력 받기] 게임 새로 시작")
    void retry_사용자로부터_재시도_여부_입력_받기_게임_새로_시작() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method retryMethod = getPrivateMethod("retry");
        input("1");
        boolean retry = (boolean) retryMethod.invoke(Application.class);

        assertThat(retry).isTrue();
    }

    @Test
    @DisplayName("[사용자로부터 재시도 여부 입력 받기] 게임 종료")
    void retry_사용자로부터_재시도_여부_입력_받기_게임_종료() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method retryMethod = getPrivateMethod("retry");
        input("2");
        boolean retry = (boolean) retryMethod.invoke(Application.class);

        assertThat(retry).isFalse();
    }

    @Test
    @DisplayName("[사용자로부터 재시도 여부 입력 받기] 1, 2가 아닌 수 입력 예외")
    void retry_사용자로부터_재시도_여부_입력_받기_입력_예외() throws NoSuchMethodException {
        Method retryMethod = getPrivateMethod("retry");
        input("3");
        Class<?> exceptionClass = null;

        try {
            retryMethod.invoke(Application.class);
        } catch (IllegalAccessException ignored) {

        } catch (InvocationTargetException e) {
            exceptionClass = e.getTargetException().getClass();
        }

        assertThat(exceptionClass).isEqualTo(IllegalArgumentException.class);
    }
}
