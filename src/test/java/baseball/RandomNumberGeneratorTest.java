package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    
    @Test
    void 난수생성_테스트() {
        randomNumberGenerator.generate();
        assertThat(randomNumberGenerator.getRandomNumberList()).isInstanceOf(List.class);
    }
    
    @Test
    void 컴퓨터객체_생성() {
        randomNumberGenerator.generate();
        Computer computer = new Computer(randomNumberGenerator.getRandomNumberList());
        System.out.println("computer.getRandomNumber() = " + computer.getRandomNumber());
    }
}