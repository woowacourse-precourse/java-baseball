package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PlayerTest {

    @Test
    @DisplayName("플레이어는 숫자 3개를 입력받아 리스트에 저장한다.")
    void sayNumbers() {
        // given
        Player player = new Player();

        // when
        List<Integer> numbers = player.sayNumbers(List.of(1, 2, 3));

        // then
        assertThat(numbers.size()).isEqualTo(3);
        assertAll(() -> assertThat(numbers.get(0)).isEqualTo(1),
                () -> assertThat(numbers.get(1)).isEqualTo(2),
                () -> assertThat(numbers.get(2)).isEqualTo(3));
    }

    @Test
    @DisplayName("입력받은 숫자 3개를 심판에게 준다.")
    void giveNumbersToReferee() {
        // given
        Player player = new Player();
        List<Integer> numbers = player.sayNumbers(List.of(1, 2, 3));

        Referee referee = new Referee();

        // when
        player.giveNumbersToReferee(referee);

        // then
        List<Integer> refereeNumbers = referee.getNumbers();
        assertThat(refereeNumbers.size()).isEqualTo(3);
        assertThat(refereeNumbers).isEqualTo(List.of(1,2,3));
    }
}