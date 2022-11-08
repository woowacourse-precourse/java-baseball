package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class NumberBaseballTest {

    @Test
    public void checkAnswerIsNotSameNumber(){
        NumberBaseball test1 = new NumberBaseball();
        assertThat(test1.getAnswer().get(0))
                .isNotEqualTo(test1.getAnswer().get(1))
                .isNotEqualTo(test1.getAnswer().get(2));
    }

}