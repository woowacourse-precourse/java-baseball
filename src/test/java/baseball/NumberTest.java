package baseball;

import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void checkCreateRandomNumber() {
        Number number = new Number();
        number.createRandomNumber();
    }
}
