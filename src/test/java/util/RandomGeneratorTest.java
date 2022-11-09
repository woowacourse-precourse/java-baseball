package util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.util.RandomGenerator.createRandomIntList;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomGeneratorTest {

    @Test
    void 랜덤_숫자_생성시_중복_여부_확인() {
        // given
        List<Integer> randomIntList = createRandomIntList(1, 9, 3);
        
        //when
        boolean result = isDistinctNumberInList(randomIntList);

        //then
        assertTrue(result);
    }

    private boolean isDistinctNumberInList(List<Integer> numberList) {
        return numberList.stream().distinct().count() == numberList.size();
    }
}
