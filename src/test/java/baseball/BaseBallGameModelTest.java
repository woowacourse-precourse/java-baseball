package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class BaseBallGameModelTest {
    @Test
    void 랜덤한_번호_생성() {
        BaseBallGameModel baseBallGameModel = new BaseBallGameModel();

        try {
            Method method = baseBallGameModel.getClass().getDeclaredMethod("createRandomNumber");
            method.setAccessible(true);
            Field field = baseBallGameModel.getClass().getDeclaredField("computer");
            field.setAccessible(true);

            method.invoke(baseBallGameModel);
            List<Integer> randomNumbers = (ArrayList) field.get(baseBallGameModel);

            for (int i = 0; i < randomNumbers.size(); i++) {
                int number = randomNumbers.get(i);

                assertThat(randomNumbers).containsOnlyOnce(number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}