package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class BaseBallGameControllerTest {
    @Test
    void 랜덤한_번호_생성() {
        BaseBallGameController baseBallGameController = new BaseBallGameController();

        try {
            Method method = baseBallGameController.getClass().getDeclaredMethod("createRandomNumber");
            method.setAccessible(true);
            Field field = baseBallGameController.getClass().getDeclaredField("computer");
            field.setAccessible(true);

            method.invoke(baseBallGameController);
            List<Integer> randomNumbers = (ArrayList) field.get(baseBallGameController);

            for (int i = 0; i < randomNumbers.size(); i++) {
                int number = randomNumbers.get(i);

                assertThat(randomNumbers).containsOnlyOnce(number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}