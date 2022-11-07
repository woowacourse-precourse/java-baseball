package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {
    NumberGenerator numberGenerator;
    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    void NumberGenerator(){
        numberGenerator.init();
        System.out.println("numberGenerator = " + numberGenerator.getComputer());
        assertThat(numberGenerator.getComputer())
                .size()
                .isEqualTo(3);
        for (Integer integer : numberGenerator.getComputer()) {
            assertThat(integer).isBetween(1,9);
        }
    }
}