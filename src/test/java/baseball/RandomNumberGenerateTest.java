package baseball;

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
}
