package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    void 잘못된_입력값_검사_테스트() {

        Player player = new Player();
        String input = "122";
        String input2 = "1245";
        String input3 = "가나다";
        String input4 = "124";

        boolean trueFlag = player.checkWrongInput(input);
        boolean trueFlag2 = player.checkWrongInput(input2);
        boolean trueFlag3 = player.checkWrongInput(input3);
        boolean falseFlag = player.checkWrongInput(input4);

        assertThat(trueFlag).isEqualTo(true);
        assertThat(trueFlag2).isEqualTo(true);
        assertThat(trueFlag3).isEqualTo(true);
        assertThat(falseFlag).isEqualTo(false);
    }

    @Test
    void 입력값_리스트_변환_테스트() {

        Player player = new Player();

        List<Integer> inputList = player.StringToList("123");
        assertThat(inputList).isEqualTo(List.of(1, 2, 3));
        assertThatThrownBy(() -> player.StringToList("가나다"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }

}