package baseball;

import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class NumberGenerateTest {
    NumberGenerator generator = new NumberGenerator();

    @Test
    void 생성된_난수_3개인지_확인() {
        generator.generateNumber();
        assertSame(3, generator.getNumbers().size());

    }

    @Test
    void 생성된_난수_범위_확인 () {
        generator.generateNumber();

        for(int number : generator.getNumbers())
            assertTrue(1 <= number && number <= 9);
    }

    @Test
    void 생성된_난수_중복확인() {
        generator.generateNumber();

        for(int number : generator.getNumbers())
            assertEquals(1, Collections.frequency(generator.getNumbers(), number));
    }
}
