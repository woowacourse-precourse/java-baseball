package baseball.randomgenerator;

import org.junit.jupiter.api.Test;
import java.util.List;

import static baseball.randomgenerator.RandomNumberGenerator.getRandomNumList;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * RandomNumberGenerator 클래스와 관련된 테스트 클래스입니다.
 * @version 1.0.0
 * @author Cho MinHo
 */
class RandomNumberGeneratorTest {

    /**
     * getRandomNumberList 메서드가 정상적으로 3개의 정수를 생성하는지에 대해 test하는 메서드입니다.
     */
    @Test
    void generateThreeNumber() {
        List<Integer> randomNumberList = getRandomNumList();
        assertThat(randomNumberList.size()).isEqualTo(3);
    }

    /**
     * getRandomNumberList 메서드가 정상적으로 3개의 서로 다른 난수를 생성하는지에 대해 test하는 메서드입니다.
     * 100번의 테스트 케이스를 통해 확인합니다.
     */
    @Test
    void isNonDuplicateNumber() {
        for (int i = 0; i < 100; i++) {
            List<Integer> randomNumberList = getRandomNumList();
            assertThat(randomNumberList.get(0)).isNotEqualTo(randomNumberList.get(1));
            assertThat(randomNumberList.get(0)).isNotEqualTo(randomNumberList.get(2));
            assertThat(randomNumberList.get(1)).isNotEqualTo(randomNumberList.get(2));
        }
    }
}