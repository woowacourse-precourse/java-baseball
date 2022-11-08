package baseball;

import org.junit.jupiter.api.Test;
import java.util.List;
import static baseball.Function.changeStringtoList;
import static baseball.Player.*;
import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    Player player = new Player();

    @Test
    void isValidAnswer_메서드_사용시_입력받은_문자열이_조건을_만족하지_못할시_예외_발생() {
        String input = "1234";

        assertThatThrownBy(() -> isValidAnswer(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임종료");
    }

    @Test
    void guessAnswer_정답_예측_메소드(){
        String input = "123";
        try {
            isValidAnswer(input);
            player.Answer = changeStringtoList(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        assertThat(player.Answer).isEqualTo(List.of(1,2,3));
    }
}
