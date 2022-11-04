package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @Test
    void isRandomNumberLengthEqualsThree(){
        RandomNumber computer = new RandomNumber();
        assertEquals(3, String.valueOf(computer.randomNumber).length());
    }
 /*   @Test
    void isEachDigitAllDifferent() {
        RandomNumber computer = new RandomNumber();
        String randomNumberString = String.valueOf(computer.randomNumber);
        String[] randomDigits = randomNumberString.split("");
    }*/

}