package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BaseballGameServiceTest {

    BaseballGameService baseballGameService = new BaseballGameService();

    @Test
    void 스트라이크_계산() {
        List<Integer> userInput = List.of(1, 2, 3);
        List<Integer> randomInput = List.of(1, 2, 3);

        List<Integer> gameResult = baseballGameService.getGameResult(userInput, randomInput);

        Assertions.assertThat(gameResult.get(0)).isEqualTo(3);
    }

    @Test
    void 볼_계산() {
        List<Integer> userInput = List.of(1, 2, 3);
        List<Integer> randomInput = List.of(3, 1, 2);

        List<Integer> gameResult = baseballGameService.getGameResult(userInput, randomInput);

        Assertions.assertThat(gameResult.get(1)).isEqualTo(3);
    }

}