package baseball.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    @DisplayName("플레이어는 숫자 3개를 입력받아 데이터에 대한 유효성 검사와 리스트로 정제하여 저장한다.")
    void sayNumbers() {
        // given
        Player player = new Player();
        List<Integer> pushNumbers = List.of(1, 2, 3);

        // when
        player.sayNumbers(pushNumbers);

        // then
        assertThat(player.getNumbers()).isEqualTo(List.of(1, 2, 3));

    }

    @Test
    @DisplayName("플레이어는 숫자 리스트를 심판에게 준다. 플레이어와 심판이 가지고 있는 숫자 리스트는 같아야 한다.")
    void giveNumbersToReferee() {
        // given
        Referee referee = new Referee();
        Player player = new Player();
        player.sayNumbers(List.of(1, 2, 3));

        List<Integer> playerNumbers = player.getNumbers();

        // when
        referee.receivePlayerNumbers(playerNumbers);

        // then
        assertThat(referee.getPlayerNumbers()).isEqualTo(playerNumbers);
    }
}