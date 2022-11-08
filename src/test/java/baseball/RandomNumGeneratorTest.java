package baseball;

import baseball.model.RandomNumGenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumGeneratorTest {
    RandomNumGenerator numGenerator;
    int MAX_SIZE = 3;
    @BeforeEach
    void setUp() {
        numGenerator= new RandomNumGenerator();
    }
    @Test
    void generateNumber(){
        assertEquals(numGenerator.getRandomNum().size(), 3);

        for (int i = 0; i < MAX_SIZE; i++) {
            assertThat(numGenerator.getRandomNum()
                    .get(i))
                    .isBetween(1, 9);
        }
    }
}
