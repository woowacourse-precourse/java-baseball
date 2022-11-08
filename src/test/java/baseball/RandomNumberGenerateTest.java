package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGenerateTest {
    @RepeatedTest(10)
    void generateRandomNumber_숫자_3개_생성() {
        Game game = new Game();
        List<Integer> randomNumbers = game.generateRandomNumber();
        assertThat(randomNumbers).hasSize(3);
    }

    @RepeatedTest(10)
    void pickNumberInRange_범위에_포함되는_숫자만_랜덤_생성() {
        int number = Randoms.pickNumberInRange(1, 9);
        assertThat(number).isGreaterThanOrEqualTo(1);
        assertThat(number).isLessThanOrEqualTo(9);
    }

    @RepeatedTest(10)
    void generateRandomNumber_중복되지_않은_숫자_생성() {
        Game game = new Game();
        List<Integer> randomNumbers = game.generateRandomNumber();
        assertThat(randomNumbers).doesNotHaveDuplicates();
    }
}
