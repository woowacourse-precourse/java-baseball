package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomNumberTest {

    @Test
    void 랜덤_넘버_생성_테스트()
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(Randoms.pickNumberInRange(1, 9));
        }

        for(Integer randomNumber : list)
        {
            assertThat(randomNumber).isGreaterThan(0);
            assertThat(randomNumber).isLessThan(10);
        }
    }

    @Test
    void 랜덤_넘버를_생성하고_검증()
    {
        GameController gameController = new GameController();
        for (int i = 0; i < 100; i++)
        {
            int randomNumber = gameController.getRandomNumber();
            assertThat(gameController.isValidUserInput(String.valueOf(randomNumber))).isEqualTo(true);
        }
    }

}
