package baseball.domain;

import domain.Command;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CommandTest {
    @Test
    void FailTovalidateInputIf(){
        String invalidInput = "3";
        assertThatThrownBy(() -> new Command(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1또는 2를 입력해야합니다.");
    }

    @Test
    void IsNotRestart(){
        String exitInput = "2";
        assertThat(new Command(exitInput).isRestart()).isEqualTo(false);
    }

    @Test
    void IsRestart(){
        String exitInput = "1";
        assertThat(new Command(exitInput).isRestart()).isEqualTo(true);
    }
}
