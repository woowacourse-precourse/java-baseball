package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Feat3Test {

    @Test
    void 스트라이크_기능_검사(){
        GameService gameService = new GameService();

        List<Integer> randomNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNUmber = new ArrayList<>(Arrays.asList(1, 2, 4));
        Integer strike = gameService.countStrike(randomNumber, userNUmber);
        assertThat(strike).isEqualTo(2);
    }

    @Test
    void 볼_기능_검사(){
        GameService gameService = new GameService();

        List<Integer> randomNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNUmber = new ArrayList<>(Arrays.asList(1, 3, 2));
        Integer ball = gameService.countBall(randomNumber, userNUmber);
        assertThat(ball).isEqualTo(2);
    }

    @Test
    void 볼_스트라이크_0일때_검사(){
        GameService gameService = new GameService();

        List<Integer> randomNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNUmber = new ArrayList<>(Arrays.asList(4, 5, 6));
        Integer strike = gameService.countStrike(randomNumber, userNUmber);
        Integer ball = gameService.countBall(randomNumber, userNUmber);
        assertThat(strike).isEqualTo(0);
        assertThat(ball).isEqualTo(0);
    }
}
