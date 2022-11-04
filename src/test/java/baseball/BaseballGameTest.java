package baseball;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballGameTest {
    BaseballGame baseballGame = new BaseballGame();
    @Test
    public void initGame_확인() throws Exception {

        Method initGameMethod = baseballGame.getClass().getDeclaredMethod("initGame");
        initGameMethod.setAccessible(true);
        initGameMethod.invoke(baseballGame);

        Field computerField=baseballGame.getClass().getDeclaredField("computer");
        computerField.setAccessible(true);
        List<Integer> computer= (List<Integer>) computerField.get(baseballGame);

        Field playerField=baseballGame.getClass().getDeclaredField("player");
        playerField.setAccessible(true);
        List<Integer> player= (List<Integer>) playerField.get(baseballGame);

        assertAll(
                ()->assertNotNull(computer),
                ()->assertEquals(computer.size(),3),

                ()->assertNotNull(player),
                ()->assertEquals(player.size(),3));
    }
    @Test
    public void playerInputValidation_확인() {
        assertAll(
                ()->assertThrows(IllegalArgumentException.class,
                        () ->Validation.validate("111")),
                ()->assertThrows(IllegalArgumentException.class,
                        () ->Validation.validate("991")),
                ()->assertThrows(IllegalArgumentException.class,
                        () ->Validation.validate("901")),
                ()->assertThrows(IllegalArgumentException.class,
                        () ->Validation.validate("a23"))
        );
    }
}