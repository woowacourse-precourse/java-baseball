package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Hint;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class HintTest extends NsTest {

    @Test
    void test_Hint_Model_ToString(){
        int ball = 2;
        int strike = 1;
        Hint hint = new Hint(ball, strike);
        assertThat(hint.toString()).isEqualTo("2볼 1스트라이크");
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
