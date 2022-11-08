package baseball.model;

import baseball.model.Ball;
import baseball.model.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void generateRandomBalls_컴퓨터가_사이즈가_3인_리스트를_잘_생성하는지_테스트() {
        //given
        Balls computerBalls = new Balls();

        //when
        while (!computerBalls.isSize(3)) {
            computerBalls.addBall(new Ball(Randoms.pickNumberInRange(1, 9)));
        }
        //then
        assertThat(computerBalls.getBalls()
                                .size()).isEqualTo(3);
    }
}