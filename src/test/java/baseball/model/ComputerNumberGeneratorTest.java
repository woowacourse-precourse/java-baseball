package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ComputerNumberGeneratorTest {

    @Test
    @DisplayName("유효한 숫자를 반환하는지 테스트")
    void testValidatedNumber() {
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        List<Integer> validated_num = computerNumberGenerator.VALIDATED_NUM;

        List<Integer> collect = validated_num.stream().distinct().collect(Collectors.toList());

        assertIterableEquals(validated_num, collect);
    }

}