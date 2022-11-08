package baseball;

import baseball.model.RandomGenerator;
import baseball.model.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class RandomGeneratorTest {
    private Validator validator;
    private RandomGenerator randomGenerator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void 서로_다른_세_자리_랜덤_숫자_설정() {
        List<Integer> quizNumber = randomGenerator.randomGenerate();
        validator.validate(quizNumber);
    }
}
