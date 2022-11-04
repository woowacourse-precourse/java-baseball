package study;

import Service.GameService;
import domain.Game;
import domain.RandomNumber;
import domain.UserNumber;
import domain.UserValidate;
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
    public void 랜덤숫자중복숫자검사() throws Exception{
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

    @Test
    public void 유저입력값사이즈확인() throws Exception{
        //given
        UserValidate userValidate = new UserValidate();
        String test1 = "1234";
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> userValidate.check_size(test1));
    }

    @Test
    public void 유저입력값숫자만인지확인() throws Exception{
        //given
        String test1 = "123";
        String test2 = "1a3";
        UserValidate userValidate = new UserValidate();

        //when
        boolean t1 = userValidate.check_int(test1);
        boolean t2 = userValidate.check_int(test2);

        //then
        assertEquals(true, t1);
        assertEquals(false, t2);
        assertThrows(IllegalArgumentException.class, () -> userValidate.check_Integer(test2));
    }

}
