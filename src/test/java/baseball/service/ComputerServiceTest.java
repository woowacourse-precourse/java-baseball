package baseball.service;

import baseball.model.Ball;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerServiceTest {

    @Test
    void generateRandomBalls_컴퓨터가_중복된_세자리_숫자_리스트를_만들때_중복된_숫자가_포함되지는_않는지_테스트() {
        //given
        List<Ball> computerBalls = new ArrayList<>();
        int[] duplicatedNumbers = new int[10];

        //when
        while (computerBalls.size() < 3) {
            Ball computerBall = new Ball(Randoms.pickNumberInRange(1, 9));
            if (computerBalls.contains(computerBall)) {
                continue;
            }
            computerBalls.add(computerBall);
            duplicatedNumbers[computerBall.getNumber()]++;
        }

        //then
        assertThat(duplicatedNumbers[computerBalls.get(0).getNumber()]).isEqualTo(1);
        assertThat(duplicatedNumbers[computerBalls.get(1).getNumber()]).isEqualTo(1);
        assertThat(duplicatedNumbers[computerBalls.get(2).getNumber()]).isEqualTo(1);
    }
}