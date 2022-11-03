package baseball.mytest;

import baseball.GameNumber;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class gameTest {

    @Test
    void 게임_1회_진행_테스트() {
        List<Integer> gameNumbers = Randoms.pickUniqueNumbersInRange(0, 9, 3);
        GameNumber gameNumber = new GameNumber(gameNumbers);

        List<Integer> userNums = Arrays.asList(1, 2, 3);
        int balls= gameNumber.getBalls(userNums);
        int strikes = gameNumber.getStrikes(userNums);

        System.out.println("strikes = " + strikes);
        System.out.println("balls = " + balls);


        List<Integer> gameNums = gameNumber.getGameNums();
        gameNums.forEach(System.out::println);
        Assertions.assertThat(gameNums.size()).isEqualTo(3);
    }
}
