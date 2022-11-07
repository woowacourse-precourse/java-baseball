package baseball.mytest;

import baseball.Application;
import baseball.GameNumber;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomGameNumberTest {

    @Test
    void 랜덤_숫자_테스트() {
        int n=0;
        while (n < 100) {
            List<Integer> uniqueNumbers = Application.pickUniqueNumbersInRange(1, 9, 3);
            GameNumber gameNumber = new GameNumber(uniqueNumbers);
            n++;
        }
    }

    @Test
    void 랜덤_숫자_객체_생성_테스트() {
        List<Integer> randomNums = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        GameNumber gameNumber = new GameNumber(randomNums);
    }
//
    @Test
    void 게임_숫자_리스트_변경_불가_테스트() {
        List<Integer> gameNums = Randoms.pickUniqueNumbersInRange(1,9,3);
        GameNumber gameNumber = new GameNumber(gameNums);

//        gameNumber.getGameNums().remove(0);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> gameNumber.getGameNums().remove(0));

    }
}
