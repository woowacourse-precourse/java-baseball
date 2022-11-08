package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
    }

    @Test
    void 숫자_1에서9까지_서로_다른_임의의_수_생성하기() {

        List<Integer> randomNumbers = baseballGame.makeRandomNum();
        HashSet<Integer> set = new HashSet<>();

        assertThat(randomNumbers.size()).isEqualTo(3);

        for (Integer number : randomNumbers) {
            set.add(number);
        }

        assertThat(set.size()).isEqualTo(3);
    }

}
