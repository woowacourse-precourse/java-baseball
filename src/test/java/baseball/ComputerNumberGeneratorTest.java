package baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class ComputerNumberGeneratorTest {

    ComputerNumberGenerator computerNumberGenerator;

    @BeforeEach
    void 컴퓨터숫자생성자_초기화(){
        computerNumberGenerator = new ComputerNumberGenerator();
    }

    @Test
    void 랜덤_넘버_1부터9를_만든다(){
        assertThat(computerNumberGenerator.createRandomNumber()).isLessThanOrEqualTo(9)
                .isGreaterThanOrEqualTo(1);
    }

    @Test
    void 값을_넣어주면_들어간다(){
        computerNumberGenerator.putNumber(100);
        assertThat(computerNumberGenerator.returnNumbersToArray()).contains(100);
    }

    @Test
    void 이미_저장_돼있으면_true(){
        computerNumberGenerator.putNumber(100);
        assertThat(computerNumberGenerator.isAlreadyInNumbers(100)).isTrue();
    }

    @Test
    void 값이_존재하지_않으면_false(){
        assertThat(computerNumberGenerator.isAlreadyInNumbers(100)).isFalse();
    }

    @Test
    void 랜덤값_1부터9가_이미_있지_않으면_저장시킨다(){
        computerNumberGenerator.insertNumber();
        assertThat(computerNumberGenerator.returnNumbersToArray().length == 1);
        assertThat(computerNumberGenerator.returnNumbersToArray()[0]).isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(9);
    }

    @Test
    void 세자리_랜덤_생성시_총_3자리만_나온다(){
        computerNumberGenerator.makeThreeDigitNumbers();
        assertThat(computerNumberGenerator.returnNumbersToArray().length).isEqualTo(3);
    }

    @Test
    void 세자리_랜덤_생성시_모두_다른값이_나온다(){
        computerNumberGenerator.makeThreeDigitNumbers();
        for(int numberEach : computerNumberGenerator.returnNumbersToArray()){
            assertThat(numberEach).isLessThanOrEqualTo(9).isGreaterThanOrEqualTo(1);
        }
    }
}
