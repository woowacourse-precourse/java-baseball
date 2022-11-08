package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import baseball.domain.ball.Balls;
import baseball.domain.generator.NumberGenerator;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;

public class NumberGeneratorTest {

    @RepeatedTest(100)
    public void 랜덤_숫자_검증_테스트(){
        List<Integer> numbers = NumberGenerator.generateRandomNumbers();
        assertDoesNotThrow(() -> Balls.of(numbers));
    }
}
