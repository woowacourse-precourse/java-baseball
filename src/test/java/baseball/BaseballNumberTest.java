package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberTest {
    @Test
    public void constructorTest(){
        BaseballNumber baseballNumber = new BaseballNumber();
        baseballNumber.makeRandomNumber();
        String createdNumber = baseballNumber.getNumber();

        Assertions.assertThat(createdNumber.length()).isEqualTo(3);

        for(int i = 0; i < 3; i++){
            for(int j = i+1; j <3; j++){
                Assertions.assertThat(createdNumber.charAt(i)).isNotEqualTo(createdNumber.charAt(j));
            }
        }
        Assertions.assertThat(Integer.parseInt(createdNumber)).isInstanceOf(Integer.class);
    }

    @Test
    public void matchTest(){
        BaseballNumber baseballNumber = new BaseballNumber();
        baseballNumber.setNumber("123");
        MatchResult matchResult = baseballNumber.match("137");
        Assertions.assertThat(matchResult.getBall()).isEqualTo(1);
        Assertions.assertThat(matchResult.getStrike()).isEqualTo(1);
    }

}