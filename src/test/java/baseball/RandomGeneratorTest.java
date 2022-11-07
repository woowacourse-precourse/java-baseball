package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {
    @Test
    public void validateTest(){
        int length= 3;
        for (int i = 0; i < 100; i++) {
            int expect=RandomGenerator.getRandomNumber(3);
            assertThat(expect).isGreaterThan((int)Math.pow(10,length-1));
            assertThat(expect).isLessThan((int)Math.pow(10,length));
        }
    }
}