package baseball;

import baseball.controller.GameController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class GameControllerTest {

    GameController gameController = new GameController();

    @Test
    void startNewGame() {
    }

    @Test
    void doesRestartTest() {
    }

    @Test
    void createTargetNumberTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // reflection
        Method createTargetNumber = GameController.class.getDeclaredMethod("createTargetNumber");
        createTargetNumber.setAccessible(true);

        // given

        // when
        List<Integer> randomDigits = (List<Integer>) createTargetNumber.invoke(gameController);

        // then
        Assertions.assertEquals(randomDigits.size(), 3);
    }
}