package baseball;

import baseball.number.client.HintsAboutNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class HintsAboutNumbersTest {

    List<Integer> randomNumbers = List.of(1,2,3);
    List<Integer> randomNumbers2 = List.of(2,2,2);
    HintsAboutNumbers hintsAboutNumbers = new HintsAboutNumbers();
    
    @Test
    void Numbers1() {

        boolean result1 = hintsAboutNumbers.hintAboutNumbers(List.of(1,2,3),randomNumbers);
        System.out.println();
        assertThat(result1).isTrue();

    }
    @Test
    void Numbers1_1() {

        boolean result1 = hintsAboutNumbers.hintAboutNumbers(List.of(2,2,3),randomNumbers2);
        System.out.println();
        assertThat(result1).isFalse();

    }

    @Test
    void Numbers1_2() {

        boolean result1 = hintsAboutNumbers.hintAboutNumbers(List.of(2,2,2),List.of(2,2,4));
        System.out.println();
        assertThat(result1).isTrue();
        //2 스트라이크 vs 1볼 2스트라이크 ??


    }

    @Test
    void Numbers2() {
        boolean result2 = hintsAboutNumbers.hintAboutNumbers(List.of(3,2,1),randomNumbers);
        System.out.println();
        assertThat(result2).isFalse();
    }

    @Test
    void Numbers3() {
        boolean result3 = hintsAboutNumbers.hintAboutNumbers(List.of(1,2,3),randomNumbers);
        System.out.println();
        assertThat(result3).isFalse();
    }

    @Test
    void Numbers4() {
        boolean result4 = hintsAboutNumbers.hintAboutNumbers(List.of(1,2,3),randomNumbers);
        System.out.println();
        assertThat(result4).isFalse();
    }

    @Test
    void Numbers5() {
        boolean result5 = hintsAboutNumbers.hintAboutNumbers(List.of(1,2,3),randomNumbers);
        System.out.println();
        assertThat(result5).isFalse();
    }

    @Test
    void Numbers6() {
        boolean result6 = hintsAboutNumbers.hintAboutNumbers(List.of(1,2,3),randomNumbers);
        System.out.println();
        assertThat(result6).isFalse();
    }
}
