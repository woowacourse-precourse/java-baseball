package baseball.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class BaseBallControllerTest extends BaseBallController{

    @Test
    void userGuessError(){
        assertThat(is3Number("1p1")).isEqualTo(false);
        assertThat(is3Number("1234")).isEqualTo(false);
    }

    @Test
    void userGuessCorrect(){
        assertThat(is3Number("231")).isEqualTo(true);
    }

    @Test
    void randomNumberNoError(){
        String target = makeRandomNumber();
        assertThat(is3Number(target)).isEqualTo(true);
    }
}