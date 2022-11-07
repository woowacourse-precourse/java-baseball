package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {
    Game game = new Game();

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
        Method checkUserInputDuplicateNumberMethod = Game.class.getDeclaredMethod("checkUserInputDuplicateNumber", String.class);
        checkUserInputDuplicateNumberMethod.setAccessible(true);

        boolean isNotDuplicated = (boolean) checkUserInputDuplicateNumberMethod.invoke(game, "123");

        assertThat(isNotDuplicated).isEqualTo(true);
    }

    @Test
    void 중복숫자_테스트2_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputDuplicateNumberMethod = Game.class.getDeclaredMethod("checkUserInputDuplicateNumber", String.class);
        checkUserInputDuplicateNumberMethod.setAccessible(true);

        boolean isNotDuplicated = (boolean) checkUserInputDuplicateNumberMethod.invoke(game, "201");

        assertThat(isNotDuplicated).isEqualTo(true);
    }

    @Test
    void 중복숫자_테스트3_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputDuplicateNumberMethod = Game.class.getDeclaredMethod("checkUserInputDuplicateNumber", String.class);
        checkUserInputDuplicateNumberMethod.setAccessible(true);

        boolean isNotDuplicated = (boolean) checkUserInputDuplicateNumberMethod.invoke(game, "122");

        assertThat(isNotDuplicated).isEqualTo(false);
    }

    @Test
    void 숫자변환_테스트1_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);

        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "122");

        assertThat(isNumber).isEqualTo(true);
    }

    @Test
    void 숫자변환_테스트2_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);

        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "012");

        assertThat(isNumber).isEqualTo(true);
    }

    @Test
    void 숫자변환_테스트3_true() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);

        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "2");

        assertThat(isNumber).isEqualTo(true);
    }

    @Test
    void 숫자변환_테스트4_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);

        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "가");

        assertThat(isNumber).isEqualTo(false);
    }

    @Test
    void 숫자변환_테스트5_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);

        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "12가3");

        assertThat(isNumber).isEqualTo(false);
    }

    @Test
    void 숫자변환_테스트6_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);

        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "+13");

        assertThat(isNumber).isEqualTo(false);
    }

    @Test
    void 숫자변환_테스트7_false() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method checkUserInputNumberMethod = Game.class.getDeclaredMethod("checkUserInputNumber", String.class);
        checkUserInputNumberMethod.setAccessible(true);

        boolean isNumber = (boolean) checkUserInputNumberMethod.invoke(game, "");

        assertThat(isNumber).isEqualTo(false);
    }
}
