package study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class NumberTest {


    @Test
    public void 컴퓨터가_서로_다른_임의의_세자리_수_생성() throws Exception{
        //given
        int randomNumber = 123;
        //when
        ArrayList<Integer> randomNumberList = new ArrayList<>(3);

        Integer indexZero = randomNumberList.get(0);
        Integer indexOne = randomNumberList.get(1);
        Integer indexTwo = randomNumberList.get(2);

        int result = randomNumberList.size();

        //then
        assertEquals(result, 3);
        assertNotEquals(indexZero, indexOne, indexTwo);

    }
}
