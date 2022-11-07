package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    @DisplayName("데이터가 숫자가 아닌 경우와 3자리가 아닌 경우 IllegalArgumentException 예외 발생")
    void validation() {
        // given
        Player player = new Player();
        String pushNumber = "a";

        // when && then
        assertThatThrownBy(() -> player.sayNumbers(pushNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number is Not Valid Exception!!");
    }

    @Test
    @DisplayName("플레이어는 숫자 3개를 입력받아 데이터에 대한 유효성 검사와 리스트로 정제하여 저장한다.")
    void sayNumbers() {
        // given
        Player player = new Player();
        String pushNumber = "123";

        // when
        player.sayNumbers(pushNumber);

        // then
        assertThat(player.getNumbers()).isEqualTo(List.of(1, 2, 3));

    }

    @Test
    @DisplayName("플레이어는 숫자 리스트를 심판에게 준다. 플레이어와 심판이 가지고 있는 숫자 리스트는 같아야 한다.")
    void giveNumbersToReferee() {
        // given
        Referee referee = new Referee(new Rule());

        Player player =  new Player();
        player.sayNumbers("123");

        // when
        player.giveNumbersToReferee(referee);

        // then
        List<Integer> refereePlayerNumbers = referee.getPlayerNumbers();
        List<Integer> playerNumbers = player.getNumbers();
        assertThat(refereePlayerNumbers).isEqualTo(playerNumbers);
    }
}