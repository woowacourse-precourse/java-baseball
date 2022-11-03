package study;

import domain.RandomNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class NumberTest {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUM_SIZE = 3;

    @Test
    public void 랜덤숫자3개범위확인() throws Exception{
        //given
        RandomNumber computer = new RandomNumber();
        computer.setRandomNumber();
        //when
        //then
        for(int val : computer.getNumbers()){
            assertFalse(val < MIN_NUMBER || val > MAX_NUMBER);
        }
    }

    @Test
    public void 랜덤숫자개수확인() throws Exception{
        //given
        RandomNumber computer = new RandomNumber();
        computer.setRandomNumber();
        //when

        //then
        assertEquals(NUM_SIZE, computer.getNumbers().length);
    }

    @Test
    public void 중복숫자검사() throws Exception{
        //given
        RandomNumber computer = new RandomNumber();
        computer.setRandomNumber();
        int[] nums = computer.getNumbers();
        Set<Integer> compare = new HashSet<>();
        //when
        for (int i = 0; i < nums.length; i++) {
            compare.add(nums[i]);
        }
        //then
        assertEquals(nums.length, compare.size());
    }
}
