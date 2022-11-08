package baseball;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestartTest {

    @Test
    void 숫자가_1이나_2가_아닐_경우_예외_처리_테스트(){
        assertThatThrownBy(() -> new Restart(5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Wrong number range");
    }

    @Test
    void 숫자가_1일_때_true_반환_테스트(){
        Restart restart = new Restart(1);
        assertTrue(restart.isRestart());
    }

    @Test
    void 숫자가_2일_때_false_반환_테스트(){
        Restart restart = new Restart(2);
        assertFalse(restart.isRestart());
    }
}
