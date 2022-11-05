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
        gameController.generateRandomNumber();
        for (int i = 0; i < 100; i++)
        {
            int randomNumber = gameController.getRandomNumber();
            assertThat(gameController.isValidUserInput(String.valueOf(randomNumber))).isEqualTo(true);
        }
    }

    @Test
    void 중복된_숫자가_있는지_확인()
    {
        GameController gameController = new GameController();
        gameController.generateRandomNumber();
        for (int i = 0; i < 100; i++)
        {
            Set<Character> set = new HashSet<Character>();
            int randomNumber = gameController.getRandomNumber();
            String randomNumberToString = String.valueOf(randomNumber);
            for(int j = 0 ; j < 3;j++)
            {
                assertThat(gameController.isValidUserInput(String.valueOf(randomNumber))).isEqualTo(true);
                set.add(randomNumberToString.charAt(j));
            }


        }
    }

}
