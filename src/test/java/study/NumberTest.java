package study;

import domain.RandomNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class NumberTest {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUM_SIZE = 3;

    @Test
    public void 랜덤숫자3개범위확인() throws Exception{
        //given
        RandomNumber computer = new RandomNumber();
        ArrayList<Integer> compare = computer.setRandomNumber();
        //when
        //then
        for(int val : compare){
            Assertions.assertFalse(val < MIN_NUMBER || val > MAX_NUMBER);
        }
    }

    @Test
    public void 랜덤숫자개수확인() throws Exception{
        //given
        RandomNumber computer = new RandomNumber();
        ArrayList<Integer> compare = computer.setRandomNumber();
        //when

        //then
        Assertions.assertEquals(NUM_SIZE, compare.size());
    }
}
