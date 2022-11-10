package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenerateRandomNumberTest {

    private static int MAX = 9;
    private static int MIN = 1;
    private static int SIZE = 3;


    GenerateRandomNumber random = new GenerateRandomNumber();



    @Test
    public void length() {
        random.setRandomNumber();
        int[] digit = random.getDigits();
        assertEquals(digit.length, SIZE); // int 배열의 길이가 3인지 확인
    }

    @Test
    public void differnt() {
        random.setRandomNumber();
        int[] digit = random.getDigits();
        random.setRandomNumber();
        int[] digitCompare = random.getDigits();
        assertArrayEquals(digit, digitCompare); // 랜덤 배열인지 확인
    }

    @Test
    public void range() {
        random.setRandomNumber();
        int[] digit = random.getDigits();
        for (int i = 0; i < digit.length; i++) {
            assertTrue(MIN <= digit[i] && digit[i] <= MAX); // 범위안에 있는지 확인
        }
    }
}