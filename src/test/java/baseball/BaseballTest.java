package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseballTest {

    @Test
    void 기능리스트_2_랜덤숫자_생성시_3자리확인(){
        Integer RandomNumberLength = Application.getAnswerRandomNumber().size();
        assertThat(RandomNumberLength).isEqualTo(3);
    }

}
