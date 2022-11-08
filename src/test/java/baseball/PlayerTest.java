package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사용자 입력 테스트")
class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    @DisplayName("사용자가 입력한 숫자를 List로 반환")
    void set_number_test() {
        //Given
        List<Integer> playerNum = List.of(1, 2, 3);
        String input = "123";

        //When
        player.setNumber(input);

        //Then
        assertThat(player.getNumber()).isEqualTo(playerNum);
    }

    @Test
    @DisplayName("사용자 입력이 숫자가 아닌 경우 예외 처리")
    void validate_num_test() {
        String input = "AAA";

        assertThatThrownBy(() -> player.setNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 외 문자가 입력되었습니다.");
    }

    @Test
    @DisplayName("사용자 입력 중 1~9범위 초과하는 요소 있을 시 예외 발생")
    void validate_range_for_all_test() {
        String input = "120";

        assertThatThrownBy(() -> player.setNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 숫자가 범위를 초과했습니다.");
    }

    @Test
    @DisplayName("사용자 입력이 3자리 이상 숫자일 때 예외 발생")
    void validate_digit_test() {
        String input = "1234";
        assertThatThrownBy(() -> player.setNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 자리 수가 아닙니다.");
    }

    @Test
    @DisplayName("사용자 입력 중 중복되는 수가 있을 때 예외 발생")
    void validate_duplication_test() {
        String input = "111";
        assertThatThrownBy(() -> player.setNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 수가 있습니다.");
    }


}