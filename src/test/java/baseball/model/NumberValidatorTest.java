package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {

    @Test
    @DisplayName("중복된 수 제거하는지 테스트")
    void testCheckIfIsNotDuplicatedNumMethod() {

        List<Integer> numbers1 = List.of(1, 2, 3);
        List<Integer> numbers2 = List.of(1, 1, 3);

        assertTrue(NumberValidator.checkIfIsNotDuplicatedNum(numbers1), "중복된 수가 없을 때 true 반환");
        assertFalse(NumberValidator.checkIfIsNotDuplicatedNum(numbers2), "중복된 수가 있을 때 false 반환");
    }

}