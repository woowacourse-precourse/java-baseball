package baseball.domain;

import baseball.generator.BaseBallNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BaseBallNumberGeneratorTest {

    @Test
    @DisplayName("")
    void BaseBallNumberGeneratorTest() {
        BaseBallNumberGenerator baseBallNumberGenerator = new BaseBallNumberGenerator();
        List<Integer> generate = baseBallNumberGenerator.generate();

        System.out.println(generate);
    }

}