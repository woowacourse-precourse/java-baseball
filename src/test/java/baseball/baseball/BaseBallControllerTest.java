package baseball.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class BaseBallControllerTest extends BaseBallController{

    /**
     * 사용자가 문자를 포함하거나 3자리 숫자가 아닌 입력일 경우 false
     */
    @Test
    void userGuessError(){
        assertThat(is3Number("1p1")).isEqualTo(false);
        assertThat(is3Number("1234")).isEqualTo(false);
        assertThat(is3Number("12")).isEqualTo(false);
    }

    /**
     * 사용자가 잘 입력 했다면 true
     */
    @Test
    void userGuessCorrect(){
        assertThat(is3Number("231")).isEqualTo(true);
    }

    /**
     * random number 에 대해서도 사용자 입력과 같은 유효성을 지니는지 확인
     * 중복되지 않는 3 숫자를 필요로 하므로 10C3 -> 120 가지의 수 이므로 대략 200번 검증
     */
    @Test
    void randomNumberNoError(){
        for(int i=0;i<200;i++) {
            String target = makeRandomNumber();
            assertThat(is3Number(target)).isEqualTo(true);
        }
    }
}