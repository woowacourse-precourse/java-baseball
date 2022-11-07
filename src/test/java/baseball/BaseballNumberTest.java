package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberTest {
    @Test
    public void testConstructor(){
        BaseballNumber baseballNumber = new BaseballNumber();
        String createdNumber = baseballNumber.getNumber();

        Assertions.assertThat(createdNumber.length()).isEqualTo(3);

        for(int i = 0; i < 3; i++){
            for(int j = i+1; j <3; j++){
                Assertions.assertThat(createdNumber.charAt(i)).isNotEqualTo(createdNumber.charAt(j));
            }
        }
        Assertions.assertThat(Integer.parseInt(createdNumber)).isInstanceOf(Integer.class);
    }
}