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
    void 랜덤_넘버_1부터9인지(){
        assertThat(100).isLessThanOrEqualTo(9)
                .isGreaterThanOrEqualTo(1);
    }

    @Test
    void 클래스_변수에_값이_저장되는지(){
        assertThat(/*ComputerNumberGenerator의 List형 변수 */).contains(100);
    }

    @Test
    void 총_3개가_저장이_되는지(){
        assertThat(/*ComputerNumberGenerator의 List형 변수의 크기*/).isEqualTo(3);
    }
}
