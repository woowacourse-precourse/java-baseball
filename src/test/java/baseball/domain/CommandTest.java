package baseball.domain;

import domain.Command;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CommandTest {
    @Test
    void FailTovalidateInputIf(){
        String invalidInput = "3";
        assertThatThrownBy(() -> Command.findByValue(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1또는 2를 입력해야합니다.");
    }

    @Test
    void IsNotRestart(){
        String exitInput = "2";
        assertThat(Command.findByValue(exitInput).equals(Command.RESTART)).isEqualTo(false);
    }

    @Test
    void IsRestart(){
        String exitInput = "1";
        assertThat(Command.findByValue(exitInput).equals(Command.RESTART)).isEqualTo(true);
    }
}
