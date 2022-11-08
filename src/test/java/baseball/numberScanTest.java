package baseball;

import baseball.utils.validation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class numberScanTest extends NsTest {



    numberScan numberScan;

    @BeforeEach
    void setUp(){
        numberScan = new numberScan();

    }


    @Test
    @DisplayName("길이 확인")
    void checkNumberSize() {
        List<Integer> makeNumber = numberScan.playerGames();
        assertThat(makeNumber.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("문자 확인")
    void checkString() {
        validation inputValidation = new validation();
        List<Integer> makeNumber = numberScan.playerGames();
        StringBuilder  chkString = new StringBuilder ();
        for(int i = 0; i < makeNumber.size() ; i++){
            chkString.append(makeNumber.get(i));
        }
        boolean checkTrue = inputValidation.checkNumber(chkString.toString());
        assertThat(checkTrue).isEqualTo(false);
    }

    @Test
    @DisplayName("예외 확인")
    void checkException(){

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("b12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
