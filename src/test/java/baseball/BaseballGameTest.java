package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class BaseballGameTest {

    BaseballGame baseballGame = new BaseballGame();

    @Test
    void startNewGame() {
    }

    @Test
    void doesRestartTest() {
    }

    @Test
    void createTargetNumberTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // reflection
        Method createTargetNumber = BaseballGame.class.getDeclaredMethod("createTargetNumber");
        createTargetNumber.setAccessible(true);

        // given

        // when
        List<Integer> randomDigits = (List<Integer>) createTargetNumber.invoke(baseballGame);

        // then
        Assertions.assertEquals(randomDigits.size(), 3);
    }
}