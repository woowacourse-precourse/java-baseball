package baseball.domain.player;

import baseball.domain.number.BaseBallGameNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Player 는 ")
class PlayerTest {

    @Test
    @DisplayName("BaseBallGameNumber를 교체할 수 있다.")
    void playerCanChangeBaseBallGameNumbers() {
        // given
        String numbers = "123";
        String changeNumbers = "321";
        BaseBallGameNumbers baseBallGameNumbers = new BaseBallGameNumbers(numbers);
        BaseBallGameNumbers changedNumbers = new BaseBallGameNumbers(changeNumbers);
        Player player = new Player();

        // when
        player.changeNumbers(baseBallGameNumbers);
        player.changeNumbers(changedNumbers);

        // then
        assertThat(player.baseBallGameNumbers()).isEqualTo(changedNumbers);
        assertThat(player.baseBallGameNumbers()).isNotEqualTo(baseBallGameNumbers);
    }
}