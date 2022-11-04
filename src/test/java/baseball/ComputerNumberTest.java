package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerNumberTest {

    private static ComputerNumber computerNumber;

    @BeforeEach
    private void setUp() {
        computerNumber = new ComputerNumber();
    }
    @Test
    void 숫자_길이_검사(){
        List<Integer> testList = computerNumber.arrayGetNumber();
        assertThat(3).isEqualTo(testList.size());
    }
    @Test
    void 숫자_중복_검사(){
        List<Integer> testList = computerNumber.arrayGetNumber();
        int firstDigitNumber = testList.get(0);
        int secondDigitNumber = testList.get(1);
        int thirdDigitNumber = testList.get(2);

        assertNotEquals(firstDigitNumber,secondDigitNumber);
        assertNotEquals(firstDigitNumber,thirdDigitNumber);
        assertNotEquals(secondDigitNumber,thirdDigitNumber);
    }

}