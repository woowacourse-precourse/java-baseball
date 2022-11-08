package baseball.unit;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControlGameTest extends NsTest {

    private static ControlGame controlGame = new ControlGame();

    @Test
    void stopGame_잘못된_입력값_예외처리_되는지_확인(){
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    run("0");
                }
        );
    }

    @Test
    void stopGame_제대로된_입력값_true_반환되는지_확인(){
        assertSimpleTest(
                () -> {
                    run("1");
                    assertThat(false);
                }
        );
    }

    @Override
    public void runMain() {
        controlGame.stopGame();
    }

}
