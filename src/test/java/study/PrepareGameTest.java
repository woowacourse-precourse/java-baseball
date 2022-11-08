package study;

import baseball.PrepareGame;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrepareGameTest {

    PrepareGame prepareGame = new PrepareGame();

    @Test
    void computer_숫자_세팅_테스트() {
        List<Integer> computerNumber = prepareGame.setComputerNumber();
        assertThat(computerNumber.size()).isEqualTo(3);
    }

    @Test
    void computer_각자리_숫자_다른지_테스트() {
        List<Integer> computerNumber = prepareGame.setComputerNumber();
        int state = 0;
        if (computerNumber.get(0) == computerNumber.get(1) || computerNumber.get(0) == computerNumber.get(2) || computerNumber.get(1) == computerNumber.get(2)) {
            state = 1;
        }
        assertThat(state).isEqualTo(0);
    }

    @Test
    void user_입력_값_숫자가_아닌_경우() {
        assertThatThrownBy(() -> prepareGame.setUserNumberForTest("1ㄱ2")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void user_입력_값_3_자리_숫자가_아닌_경우() {
        assertThatThrownBy(() -> prepareGame.setUserNumberForTest("3596")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void user_올바른_입력_값인_경우() {
        assertThat(prepareGame.setUserNumberForTest("245")).isEqualTo("245");
    }
}
