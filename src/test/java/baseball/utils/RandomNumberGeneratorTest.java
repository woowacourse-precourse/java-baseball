package baseball.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @AfterEach
    public void afterEach() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    @DisplayName("생성한 숫자가 세자리인가?")
    public void 생성한_숫자가_세자리인지_확인() {
        assertThat(randomNumberGenerator.getRandomNumberList()).size().isEqualTo(3);
        for (int i = 0; i < 3; i++) {
            int num = randomNumberGenerator.getRandomNumberList().get(i);
            assertThat(num).isBetween(1, 9);
        }
    }

    @Test
    @DisplayName("생성한 숫자의 각 자릿수가 서로 다른 수들로 이루어져있는가?")
    public void 생성한_숫자의_각_자릿수가_서로_다른_수인지_확인() {
        HashSet<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            int num = randomNumberGenerator.getRandomNumberList().get(i);
            numberSet.add(num);
        }
        assertThat(numberSet).size().isEqualTo(3);
    }

}
