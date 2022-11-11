package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class GenerateRandomNumberTest {

    private static int MAX = 9;
    private static int MIN = 1;
    private static int SIZE = 3;


    GenerateRandomNumber random = new GenerateRandomNumber();



    @Test
    public void length() {
        random.setRandomNumber();
        List<Integer> digit = random.getDigits();
        assertEquals(digit.size(), SIZE); // int 배열의 길이가 3인지 확인
    }

    @Test
    public void differnt() {
        random.setRandomNumber();
        List<Integer> digit = random.getDigits();
        random.setRandomNumber();
        List<Integer> digitCompare = random.getDigits();
        assertEquals(digit, digitCompare); // 랜덤 배열인지 확인
    }

    @Test
    public void range() {
        random.setRandomNumber();
        List<Integer> digit = random.getDigits();
        for (int i = 0; i < digit.size(); i++) {
            assertTrue(MIN <= digit.get(i) && digit.get(i) <= MAX); // 범위안에 있는지 확인
        }
    }
}