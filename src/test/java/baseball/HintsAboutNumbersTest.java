package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HintsAboutNumbersTest {

    int randomNumbers = 123;
    HintsAboutNumbers hintsAboutNumbers = new HintsAboutNumbers();
    
    @Test
    void Numbers1() {

        boolean result1 = hintsAboutNumbers.hintAboutNumbers(123,randomNumbers);
        System.out.println();
        assertThat(result1).isTrue();

    }

    @Test
    void Numbers2() {
        boolean result2 = hintsAboutNumbers.hintAboutNumbers(124,randomNumbers);
        System.out.println();
        assertThat(result2).isFalse();
    }

    @Test
    void Numbers3() {
        boolean result3 = hintsAboutNumbers.hintAboutNumbers(312,randomNumbers);
        System.out.println();
        assertThat(result3).isFalse();
    }

    @Test
    void Numbers4() {
        boolean result4 = hintsAboutNumbers.hintAboutNumbers(321,randomNumbers);
        System.out.println();
        assertThat(result4).isFalse();
    }

    @Test
    void Numbers5() {
        boolean result5 = hintsAboutNumbers.hintAboutNumbers(391,randomNumbers);
        System.out.println();
        assertThat(result5).isFalse();
    }

    @Test
    void Numbers6() {
        boolean result6 = hintsAboutNumbers.hintAboutNumbers(456,randomNumbers);
        System.out.println();
        assertThat(result6).isFalse();
    }
}
