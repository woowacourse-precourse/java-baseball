package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ComputerTest {
    Computer computer = new Computer();
    @Test
    void 랜덤한_숫자의_길이가_3인지_확인() {
        assertThat(3).isEqualTo(computer.randomNumberToStringResult().length());
    }

    @Test
    void 랜덤한_숫자중_중복된_수가_없는지_확인 () {
        String test = computer.randomNumberToStringResult();
        int checkDigit = 0;
        if(test.substring(0,1).equals(test.substring(1,2))) {
            checkDigit ++;
        }
        if(test.substring(0,1).equals(test.substring(2,3))) {
            checkDigit ++;
        }
        if(test.substring(1,2).equals(test.substring(2,3))) {
            checkDigit ++;
        }
        assertThat(0).isEqualTo(checkDigit);
    }

    @Test
    void 랜덤한_숫자중_0의__존재여부_확인 (){
        assertThat(false).isEqualTo(computer.randomNumberToStringResult().contains("0"));
    }

}
