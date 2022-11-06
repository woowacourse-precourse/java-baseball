package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

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
}
