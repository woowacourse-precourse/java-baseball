package baseball.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberHandlerTest {

    @Test
    @DisplayName("랜덤으로 생성된 세자리 숫자에서 중복이 있는지 테스트")
    void checkDuplication() {
        // given
        List<Integer> randomNumberList = NumberHandler.createRandomNumberList();

        // when
        Set<Integer> randomNumberSet = new HashSet<>(randomNumberList);

        // then
        assertEquals(randomNumberSet.size(), 3);
    }

    @Test
    @DisplayName("세자리 숫자를 size 3의 List로 변환하는지 테스트")
    void splitTest() {
        // given
        int numbers = 123;

        // when
        List<Integer> numberList = NumberHandler.splitNumber(numbers);

        // then
        assertEquals(numberList.size(), 3);
        assertEquals(numberList, List.of(1, 2, 3));
    }
}
