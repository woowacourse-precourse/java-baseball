package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void 잘못된_입력값_검사_테스트() {

        Player player = new Player();
        String input = "122";
        String input2 = "1245";
        String input3 = "124";

        boolean trueFlag = player.checkWrongInput(input);
        boolean trueFlag2 = player.checkWrongInput(input2);
        boolean falseFlag = player.checkWrongInput(input3);

        assertThat(trueFlag).isEqualTo(true);
        assertThat(trueFlag2).isEqualTo(true);
        assertThat(falseFlag).isEqualTo(false);
    }

}