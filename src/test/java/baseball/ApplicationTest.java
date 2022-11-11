package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    Game game = new Game();

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
    void 게임_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "132", "1", "597", "417", "419", "2");
                    assertThat(output()).
                    contains("1볼", "2스트라이크", "3스트라이크", "1볼", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 2, 4, 1, 9
        );
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("+12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트4() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("246", "135", "132", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 2
        );
    }

    @Test
    void 게임_재시작_테스트_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkInputPlayGameMethod = Game.class.getDeclaredMethod("checkInputPlayGame", String.class);
        checkInputPlayGameMethod.setAccessible(true);
        boolean isPlay = (boolean) checkInputPlayGameMethod.invoke(game, "1");
        assertThat(isPlay).isEqualTo(true);
    }

    @Test
    void 게임_재시작_테스트_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkInputPlayGameMethod = Game.class.getDeclaredMethod("checkInputPlayGame", String.class);
        checkInputPlayGameMethod.setAccessible(true);
        boolean isPlay = (boolean) checkInputPlayGameMethod.invoke(game, "");
        assertThat(isPlay).isEqualTo(false);
    }

    @Test
    void 중복숫자_테스트1_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputDuplicateNumberMethod =
                Game.class.getDeclaredMethod("checkUserInputDuplicateNumber", String.class);
        checkUserInputDuplicateNumberMethod.setAccessible(true);
        boolean isNotDuplicated = (boolean) checkUserInputDuplicateNumberMethod.invoke(game, "123");
        assertThat(isNotDuplicated).isEqualTo(true);
    }

    @Test
    void 중복숫자_테스트2_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputDuplicateNumberMethod =
                Game.class.getDeclaredMethod("checkUserInputDuplicateNumber", String.class);
        checkUserInputDuplicateNumberMethod.setAccessible(true);
        boolean isNotDuplicated = (boolean) checkUserInputDuplicateNumberMethod.invoke(game, "201");
        assertThat(isNotDuplicated).isEqualTo(true);
    }

    @Test
    void 중복숫자_테스트3_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputDuplicateNumberMethod =
                Game.class.getDeclaredMethod("checkUserInputDuplicateNumber", String.class);
        checkUserInputDuplicateNumberMethod.setAccessible(true);
        boolean isNotDuplicated = (boolean) checkUserInputDuplicateNumberMethod.invoke(game, "122");
        assertThat(isNotDuplicated).isEqualTo(false);
    }

    @Test
    void 숫자변환_테스트1_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod =
                Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "122");
        assertThat(isNumber).isEqualTo(true);
    }

    @Test
    void 숫자변환_테스트2_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod =
                Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "012");
        assertThat(isNumber).isEqualTo(false);
    }

    @Test
    void 숫자변환_테스트3_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod =
                Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "2");
        assertThat(isNumber).isEqualTo(false);
    }

    @Test
    void 숫자변환_테스트4_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod =
                Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "가");
        assertThat(isNumber).isEqualTo(false);
    }

    @Test
    void 숫자변환_테스트5_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod =
                Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "12가3");
        assertThat(isNumber).isEqualTo(false);
    }

    @Test
    void 숫자변환_테스트6_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod =
                Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "+13");
        assertThat(isNumber).isEqualTo(false);
    }

    @Test
    void 숫자변환_테스트7_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod =
                Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "");
        assertThat(isNumber).isEqualTo(false);
    }

    @Test
    void 영포함여부_테스트1_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputContainZeroMethod =
                Game.class.getDeclaredMethod("checkUserInputContainZero", String.class);
        checkUserInputContainZeroMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputContainZeroMethod.invoke(game, "132");
        assertThat(isNumber).isEqualTo(false);
    }

    @Test
    void 영포함여부_테스트2_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputContainZeroMethod =
                Game.class.getDeclaredMethod("checkUserInputContainZero", String.class);
        checkUserInputContainZeroMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputContainZeroMethod.invoke(game, "1332");
        assertThat(isNumber).isEqualTo(false);
    }

    @Test
    void 영포함여부_테스트3_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputContainZeroMethod =
                Game.class.getDeclaredMethod("checkUserInputContainZero", String.class);
        checkUserInputContainZeroMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputContainZeroMethod.invoke(game, "");
        assertThat(isNumber).isEqualTo(false);
    }

    @Test
    void 영포함여부_테스트4_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputContainZeroMethod =
                Game.class.getDeclaredMethod("checkUserInputContainZero", String.class);
        checkUserInputContainZeroMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputContainZeroMethod.invoke(game, "103");
        assertThat(isNumber).isEqualTo(true);
    }

    @Test
    void 문자열길이체크1_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputLengthMethod =
                Game.class.getDeclaredMethod("checkUserInputLength", String.class);
        checkUserInputLengthMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputLengthMethod.invoke(game, "153");
        assertThat(isNumber).isEqualTo(true);
    }

    @Test
    void 문자열길이체크2_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputLengthMethod =
                Game.class.getDeclaredMethod("checkUserInputLength", String.class);
        checkUserInputLengthMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputLengthMethod.invoke(game, "가나1");
        assertThat(isNumber).isEqualTo(true);
    }

    @Test
    void 문자열길이체크3_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputLengthMethod =
                Game.class.getDeclaredMethod("checkUserInputLength", String.class);
        checkUserInputLengthMethod.setAccessible(true);
        boolean isNumber = (boolean) checkUserInputLengthMethod.invoke(game, "31");
        assertThat(isNumber).isEqualTo(false);
    }

    @Test
    void 사용자입력체크1_정상() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputMethod =
                Game.class.getDeclaredMethod("checkUserInput", String.class);
        checkUserInputMethod.setAccessible(true);
        checkUserInputMethod.invoke(game, "325");
    }

    @Test
    void 사용자입력체크2_정상() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputMethod =
                Game.class.getDeclaredMethod("checkUserInput", String.class);
        checkUserInputMethod.setAccessible(true);
        checkUserInputMethod.invoke(game, "129");
    }

    @Test
    void 랜덤넘버생성_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method createSecretNumberMethod =
                Game.class.getDeclaredMethod("createSecretNumber");
        createSecretNumberMethod.setAccessible(true);
        Method checkUserInputMethod = Game.class.getDeclaredMethod("checkUserInput", String.class);
        checkUserInputMethod.setAccessible(true);
        for (int i = 0; i < 100; i++) {
            List<Integer> secretNumber = (List<Integer>) createSecretNumberMethod.invoke(game);
            String secretString = secretNumber.stream().map(String::valueOf)
                    .collect(Collectors.joining());
            checkUserInputMethod.invoke(game, secretString);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
