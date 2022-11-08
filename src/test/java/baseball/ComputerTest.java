package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ComputerTest {
    Computer computer = new Computer();
    @Test
    void 랜덤문자열을_받아서_나온_케이스의_길이가_3인지_출력() {
        assertThat(3).isEqualTo(computer.randomNumberToStringResult().length());
    }

    @Test
    void 랜덤문자열을_받아서_나온_케이스가_각각_자릿수가_다른지 () {
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
    void 랜덤문자열을_받아서_나온_케이스에_0이_존재하는지 (){
        assertThat(false).isEqualTo(computer.randomNumberToStringResult().contains("0"));
    }

}
