package baseball.computer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class ValidatorTest {

    @Test
    public void test_정수_체크() {
        String n = "12345";

        boolean output = Validator.isInteger(n);

        Assertions.assertTrue(output);
    }

    @Test
    public void test_정수_체크2() {
        String n = "123a45";

        boolean output = Validator.isInteger(n);

        Assertions.assertFalse(output);
    }

    @Test
    public void test_정수_유효성_체크() {
        Integer n = 985;

        boolean output = Validator.isValidInteger(n);

        Assertions.assertTrue(output);
    }

    @Test
    public void test_정수_유효성_체크2() {
        Integer n = 1000;

        boolean output = Validator.isValidInteger(n);

        Assertions.assertFalse(output);
    }

    @Test
    public void test_게임진행여부_유효성_체크() {
        Integer n = 0;

        boolean output = Validator.isValidAnswer(n);

        Assertions.assertTrue(output);
    }

    @Test
    public void test_게임진행여부_유효성_체크2() {
        Integer n = 1;

        boolean output = Validator.isValidAnswer(n);

        Assertions.assertTrue(output);
    }

    @Test
    public void test_게임진행여부_유효성_체크3() {
        Integer n = 2;

        boolean output = Validator.isValidAnswer(n);

        Assertions.assertFalse(output);
    }

}