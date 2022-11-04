package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    Integer randomNumber;
    String randomNumberStringType;

    @BeforeEach
    void 랜덤넘버초기화(){
        randomNumber = RandomNumberGenerator.generate();
        randomNumberStringType =  String.valueOf(randomNumber);
    }

    @Test
    void 랜덤넘버는3자리숫자이다(){
        assertThat(randomNumberStringType.length()).isEqualTo(3);
    }

    @Test
    void 랜덤넘버의각자리수에0은불가능하다() {
        assertThat(randomNumberStringType.toCharArray()).doesNotContain('0');
    }

    @Test
    void 랜덤넘버의각자리수는다르다() {
        assertThat(randomNumberStringType.charAt(0)).isNotEqualTo(randomNumberStringType.charAt(1));
        assertThat(randomNumberStringType.charAt(1)).isNotEqualTo(randomNumberStringType.charAt(2));
        assertThat(randomNumberStringType.charAt(0)).isNotEqualTo(randomNumberStringType.charAt(2));
    }

    @Test
    void 랜덤넘버이므로여러번검증() {
        for (int iter = 0; iter < 10000; ++iter){
            this.랜덤넘버의각자리수에0은불가능하다();
            this.랜덤넘버의각자리수는다르다();
        }
    }
}