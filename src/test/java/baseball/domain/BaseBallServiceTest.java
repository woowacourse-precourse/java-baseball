package baseball.domain;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BaseBallServiceTest {

    BaseBallService baseBallService = new BaseBallServiceImpl();

    @Nested
    class RandomNumberTest {
        @RepeatedTest(100)
        @Test
        void selectRandomNumbers() {

            //when
            List<Integer> numbers = baseBallService.selectRandomNumbers();

            //then
            assertDoesNotThrow(() -> {
                validateNumbers(numbers);
            });
        }

        void validateNumbers(List<Integer> numbers) {

            if (numbers.size() != 3)
                throw new IllegalArgumentException();

            for (int num : numbers) {
                if (num < 1 || num > 9)
                    throw new IllegalArgumentException();
            }
        }
    }
    @Test
    void 볼_스트라이크_카운트_확인(){

        List<Integer> originNumbers = Arrays.asList(5,7,8);
        List<Integer> userNumbers = Arrays.asList(5,1,7);

        baseBallService.saveRandomNumbers(originNumbers);
        GameResult gameResult = baseBallService.compareNumbers(userNumbers);

        assertEquals(gameResult.getStrikeCount(),1);
        assertEquals(gameResult.getBallCount(),1);
    }
}