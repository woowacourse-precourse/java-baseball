package baseball.computer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class ValidatorTest {

    @Test
    public void test_정수_체크() {
        String n = "12345";

        boolean output = Validator.isInteger(n);

        Assertions.assertEquals(true, output);
    }

    @Test
    public void test_정수_체크2() {
        String n = "123a45";

        boolean output = Validator.isInteger(n);

        Assertions.assertEquals(false, output);
    }

    @Test
    public void test_정수_유효성_체크() {
        Integer n = 985;

        boolean output = Validator.isValidInteger(n);

        Assertions.assertEquals(true, output);
    }

    @Test
    public void test_정수_유효성_체크2() {
        Integer n = 1000;

        boolean output = Validator.isValidInteger(n);

        Assertions.assertEquals(false, output);
    }
}