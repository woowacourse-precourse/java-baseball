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



}
