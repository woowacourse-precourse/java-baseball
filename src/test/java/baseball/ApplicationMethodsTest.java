package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class ApplicationMethodsTest {

    @Test
    void generateRandomNumberTest() {
        String randomNumber = Application.generateRandomNumber();
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < randomNumber.length(); i++) {
            hashSet.add(randomNumber.charAt(i));
        }
        assertThat(randomNumber.length()).isEqualTo(3);
        assertThat(randomNumber.length()).isEqualTo(hashSet.size());
    }

    @Test
    void validateInputNumberTest() {
        try {
            String testNumber = "1789";
            Application.validateInputNumber(testNumber);
            fail();
        } catch (IllegalArgumentException illegalArgumentException) {

        }
    }

    @Test
    void isAllInRangeTest() {
        String testNumber1 = "123";
        String testNumber2 = "012";

        boolean result1 = Application.isAllInRange(testNumber1);
        boolean result2 = Application.isAllInRange(testNumber2);


        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
    }

    @Test
    void isAllUniqueTest() {
        String testNumber1 = "123";
        String testNumber2 = "114";

        boolean result1 = Application.isAllUnique(testNumber1);
        boolean result2 = Application.isAllUnique(testNumber2);

        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
    }
}
