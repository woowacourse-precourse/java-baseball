package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
    }

    @Test
    void 숫자_1에서9까지_서로_다른_임의의_수_생성하기() {

        List<Integer> randomNumbers = baseballGame.makeRandomNum();
        HashSet<Integer> set = new HashSet<>();

        assertThat(randomNumbers.size()).isEqualTo(3);

        for (Integer number : randomNumbers) {
            set.add(number);
        }

        assertThat(set.size()).isEqualTo(3);
    }

    @Test
    void 유저의_입력값_알맞은_값인지_확인하기() {

        String tooLongInput = "12345";
        assertThatThrownBy(() -> baseballGame.checkUserInput(tooLongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 이상을 입력하였습니다.");

        String wrongInput = "1a2";
        assertThatThrownBy(() -> baseballGame.checkUserInput(wrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 다른 문자를 입력하였습니다.");

        String duplicateInput = "122";
        assertThatThrownBy(() -> baseballGame.checkUserInput(duplicateInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자를 입력하였습니다.");
    }

}
