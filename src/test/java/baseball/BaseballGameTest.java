package baseball;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    BaseballGame baseballGame = new BaseballGame();

    @Test
    void 랜덤숫자_3자리_생성_테스트() throws Exception {
        Method method = baseballGame.getClass().getDeclaredMethod("makeRandomNumbers");
        method.setAccessible(true);

        List<Integer> numbers = (List<Integer>) method.invoke(baseballGame);
        assertThat(numbers).hasSize(3);
    }

    @Test
    void 랜덤숫자_범위_테스트() throws Exception {
        Method method = baseballGame.getClass().getDeclaredMethod("makeRandomNumbers");
        method.setAccessible(true);

        List<Integer> numbers = (List<Integer>) method.invoke(baseballGame);

        assertThat(numbers.get(0)).isGreaterThan(0);
        assertThat(numbers.get(0)).isLessThan(10);

        assertThat(numbers.get(1)).isGreaterThan(0);
        assertThat(numbers.get(1)).isLessThan(10);

        assertThat(numbers.get(2)).isGreaterThan(0);
        assertThat(numbers.get(2)).isLessThan(10);
    }

    @Test
    void 게임_결과_테스트() throws Exception {
        Method method = baseballGame.getClass().getDeclaredMethod("checkNumber", List.class, int.class);
        method.setAccessible(true);

        boolean result = (boolean) method.invoke(baseballGame, List.of(4, 2, 5), 425);
        assertThat(result).isEqualTo(true);

        result = (boolean) method.invoke(baseballGame, List.of(2, 4, 5), 425);
        assertThat(result).isEqualTo(false);
    }

}