package baseball.mytest;

import baseball.GameNumber;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomGameNumberTest {

    @Test
    void 랜덤_숫자_테스트(){
        List<Integer> randomNums = Randoms.pickUniqueNumbersInRange(0, 10, 3);

    }

    @Test
    void 랜덤_숫자_객체_생성_테스트() {
        List<Integer> randomNums = Randoms.pickUniqueNumbersInRange(0, 10, 3);
        GameNumber gameNumber = new GameNumber(randomNums);
    }
}
