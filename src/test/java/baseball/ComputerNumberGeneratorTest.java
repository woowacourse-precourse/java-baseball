package baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class ComputerNumberGeneratorTest {

    ComputerNumberGenerator computerNumberGenerator;

    @BeforeEach
    void 컴퓨터숫자생성자_초기화(){
        computerNumberGenerator = new ComputerNumberGenerator();
    }

    @Test
    void 랜덤_넘버_1부터9_리턴(){
        assertThat(100).isLessThanOrEqualTo(9)
                .isGreaterThanOrEqualTo(1);
    }

    @Test
    void 이미_저장_돼있으면_true(){
        assertThat(false).isTrue();
    }

    @Test
    void 클래스_변수에_값이_저장(){
        computerNumberGenerator.insertNumber(100);
        assertThat(computerNumberGenerator.returnNumbersToArray()).contains(100);
    }

    @Test
    void 랜덤값_3개가_저장(){
        computerNumberGenerator.makeThreeDigitNumbers();
        assertThat(computerNumberGenerator.returnNumbersToArray().length).isEqualTo(3);
    }
}
