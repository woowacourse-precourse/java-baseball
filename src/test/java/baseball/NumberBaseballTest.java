package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class NumberBaseballTest {

    @Test
    public void testAnswerIsNotSameNumber(){
        NumberBaseball test1 = new NumberBaseball();
        assertThat(test1.getAnswer().get(0))
                .isNotEqualTo(test1.getAnswer().get(1))
                .isNotEqualTo(test1.getAnswer().get(2));
    }

    @Test
    public void testCheckInput(){
        NumberBaseball test2 = new NumberBaseball();
        assertThat(test2.checkInput("359")).isEqualTo(true);
    }

}