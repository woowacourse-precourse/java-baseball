package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BaseBallGameModelTest {
    @Test
    void 랜덤한_번호_생성() {
        BaseBallGameModel baseBallGameModel = new BaseBallGameModel();

        try {
            Field field = baseBallGameModel.getClass().getDeclaredField("computerNumbers");
            field.setAccessible(true);

            List<Integer> randomNumbers = (ArrayList) field.get(baseBallGameModel);

            for (int i = 0; i < randomNumbers.size(); i++) {
                int number = randomNumbers.get(i);

                assertThat(randomNumbers).containsOnlyOnce(number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void 볼_스트라이크_확인1() {
        BaseBallGameModel baseBallGameModel = new BaseBallGameModel();

        try {
            Field field = baseBallGameModel.getClass().getDeclaredField("computerNumbers");
            field.setAccessible(true);

            List<Integer> randomNumbers = Arrays.asList(1, 2, 3);
            List<Integer> userNumber = Arrays.asList(3, 1, 2);
            field.set(baseBallGameModel, randomNumbers);

            Assertions.assertThat(baseBallGameModel.ballCount(userNumber)).isEqualTo(3);
            Assertions.assertThat(baseBallGameModel.strikeCount(userNumber)).isEqualTo(0);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }
    }

    @Test
    void 볼_스트라이크_확인2() {
        BaseBallGameModel baseBallGameModel = new BaseBallGameModel();

        try {
            Field field = baseBallGameModel.getClass().getDeclaredField("computerNumbers");
            field.setAccessible(true);

            List<Integer> randomNumbers = Arrays.asList(1, 2, 3);
            List<Integer> userNumber = Arrays.asList(5, 6, 1);
            field.set(baseBallGameModel, randomNumbers);

            Assertions.assertThat(baseBallGameModel.ballCount(userNumber)).isEqualTo(1);
            Assertions.assertThat(baseBallGameModel.strikeCount(userNumber)).isEqualTo(0);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }
    }

    @Test
    void 볼_스트라이크_확인3() {
        BaseBallGameModel baseBallGameModel = new BaseBallGameModel();

        try {
            Field field = baseBallGameModel.getClass().getDeclaredField("computerNumbers");
            field.setAccessible(true);

            List<Integer> randomNumbers = Arrays.asList(1, 2, 3);
            List<Integer> userNumber = Arrays.asList(3, 1, 2);
            field.set(baseBallGameModel, randomNumbers);

            Assertions.assertThat(baseBallGameModel.ballCount(userNumber)).isEqualTo(3);
            Assertions.assertThat(baseBallGameModel.strikeCount(userNumber)).isEqualTo(0);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }
    }

    @Test
    void 볼_스트라이크_확인4() {
        BaseBallGameModel baseBallGameModel = new BaseBallGameModel();

        try {
            Field field = baseBallGameModel.getClass().getDeclaredField("computerNumbers");
            field.setAccessible(true);

            List<Integer> randomNumbers = Arrays.asList(1, 2, 3);
            List<Integer> userNumber = Arrays.asList(1, 2, 3);
            field.set(baseBallGameModel, randomNumbers);

            Assertions.assertThat(baseBallGameModel.ballCount(userNumber)).isEqualTo(0);
            Assertions.assertThat(baseBallGameModel.strikeCount(userNumber)).isEqualTo(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}