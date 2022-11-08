package baseball.Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class ValidatorTest {

    @Test
    public void 숫자_중복_검사() {
        List<Integer> testList = List.of(1, 2, 2);
        assertFalse(Validator.checkIsNotDuplicateNums(testList));
    }

    @Test
    public void 길이_예외_검사() {
        List<Integer> testList = List.of(1, 3, 5, 7);
        assertFalse(Validator.checkIsLength3(testList));
    }

    @Test
    public void 숫자범위_예외_검사() {
        List<Integer> testList = List.of(11, 2, 8);
        assertFalse(Validator.checkIsValidNums(testList));
    }

    @Test
    public void 숫자_생성_전체_테스트() {
        List<Integer> testList = List.of(7, 2, 8);
        assertTrue(Validator.checkIsCorrectNums(testList));
    }
}
