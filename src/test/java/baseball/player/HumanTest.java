package baseball.player;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void getAnswer_정답_가져오기() {

    }

    @Test
    void inputAnswer_정답_입력() {
        Playable human = new Human();
        human.inputAnswer();

        List<Integer> answer = List.of(1, 2, 3);

        assertThat(human.getAnswer())
                .isEqualTo(answer);
    }
}