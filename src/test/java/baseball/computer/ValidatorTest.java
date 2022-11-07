package baseball.computer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ValidatorTest {

    @Test
    public void 정수_정상_테스트() {
        String n = "12345";

        boolean output = Validator.isInteger(n);

        Assertions.assertTrue(output);
    }

    @Test
    public void 정수_문자_예외_테스트() {
        String n = "123a45";

        boolean output = Validator.isInteger(n);

        Assertions.assertFalse(output);
    }

    @Test
    public void 정수_범위_테스트() {
        Integer n = 985;

        boolean output = Validator.isValidInteger(n);

        Assertions.assertTrue(output);
    }

    @Test
    public void 정수_범위_초과_테스트() {
        Integer n = 1000;

        boolean output = Validator.isValidInteger(n);

        Assertions.assertFalse(output);
    }

    @Test
    public void 게임진행여부_정상범위_테스트() {
        Integer n = 1;

        boolean output = Validator.isValidAnswer(n);

        Assertions.assertTrue(output);
    }

    @Test
    public void 게임진행여부_정상범위_테스트2() {
        Integer n = 2;

        boolean output = Validator.isValidAnswer(n);

        Assertions.assertTrue(output);
    }

    @Test
    public void 게임진행여부_비정상범위_예외_테스트() {
        Integer n = 999;

        boolean output = Validator.isValidAnswer(n);

        Assertions.assertFalse(output);
    }

}