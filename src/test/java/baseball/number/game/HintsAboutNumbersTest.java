package baseball.number.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class HintsAboutNumbersTest {

    List<Integer> randomNumbers = List.of(1,2,3);
    HintsAboutNumbers hintsAboutNumbers = new HintsAboutNumbers();
    
    @Test
    @DisplayName("3스트라이크")
    void Numbers1() {

        boolean result1 = hintsAboutNumbers.hintAboutNumbers(List.of(1,2,3),randomNumbers);
        System.out.println();
        assertThat(result1).isTrue();

    }

    @Test
    @DisplayName("2볼 1스트라이크")
    void Numbers2() {
        boolean result2 = hintsAboutNumbers.hintAboutNumbers(List.of(3,2,1),randomNumbers);
        System.out.println();
        assertThat(result2).isFalse();
    }
    @Test
    @DisplayName("1스트라이크")
    void Numbers3() {
        boolean result2 = hintsAboutNumbers.hintAboutNumbers(List.of(8,2,9),randomNumbers);
        System.out.println();
        assertThat(result2).isFalse();
    }

    @Test
    @DisplayName("2스트라이크")
    void Numbers4() {
        boolean result4 = hintsAboutNumbers.hintAboutNumbers(List.of(1,2,4),randomNumbers);
        System.out.println();
        assertThat(result4).isFalse();
    }

    @Test
    @DisplayName("3볼")
    void Numbers5() {
        boolean result5 = hintsAboutNumbers.hintAboutNumbers(List.of(2,3,1),randomNumbers);
        System.out.println();
        assertThat(result5).isFalse();
    }

    @Test
    @DisplayName("2볼")
    void Numbers6() {
        boolean result6 = hintsAboutNumbers.hintAboutNumbers(List.of(3,4,1),randomNumbers);
        System.out.println();
        assertThat(result6).isFalse();
    }

    @Test
    @DisplayName("낫싱")
    void Numbers7() {
        boolean result7 = hintsAboutNumbers.hintAboutNumbers(List.of(5,6,7),randomNumbers);
        System.out.println();
        assertThat(result7).isFalse();
    }
}
