package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    @DisplayName("세자리 랜덤 숫자 생성")
    void generateRandomNumber() {
        Computer computer = new Computer();
        List<Integer> digits = computer.getDigits();

        assertEquals(3, digits.size());
        assertNotSame(digits.get(0), digits.get(1));
        assertNotSame(digits.get(1), digits.get(2));
    }

    @Test
    @DisplayName("숫자 비교")
    void compareDigits() {
        int result = 3;
        Computer computer = new Computer();
        List<Integer> digits = computer.getDigits();

        assertEquals(result, computer.compareDigits(digits).getStrike());
    }
}