package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameNumbersTest {
    private final Computer computer = Computer.getInstance();
    private final Player player = Player.getInstance();

    @Test
    @DisplayName("컴퓨터숫자 생성 : 랜덤 숫자를 생성하여 리스트에 저장해 반환")
    void 컴퓨터숫자_생성() {
        List<Integer> computerNumbers = computer.generateGameNumberList();
        assertThat(computerNumbers)
                .isNotNull()
                .isInstanceOf(List.class);
        assertEquals(computerNumbers.size(), 3);
    }

    @Test
    @DisplayName("사용자숫자 생성 : 올바른 값을 입력받은 경우 리스트에 저장해 반환")
    void 사용자숫자_생성_올바른_값을_입력받은_경우() {
        List<Integer> guessingNumbers = player.generateGameNumberList("123");
        assertThat(guessingNumbers)
                .isNotNull()
                .isInstanceOf(List.class);
        assertEquals(guessingNumbers.size(), 3);
    }

    @Test
    @DisplayName("사용자숫자 생성 : 범위 밖의 숫자를 입력받은 경우 예외발생")
    void 사용자숫자_생성_범위_밖의_숫자를_입력받은_경우_예외발생() {
        assertThatThrownBy(() -> player.generateGameNumberList("108"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[오류] 숫자는 1보다 작을 수 없습니다.");
    }

    @Test
    @DisplayName("사용자숫자 생성 : 첫번째 숫자로 0을 입력받은 경우 예외발생")
    void 사용자숫자_생성_첫번째_숫자로_0을_입력받은_경우_예외발생() {
        assertThatThrownBy(() -> player.generateGameNumberList("023"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[오류] 숫자는 1보다 작을 수 없습니다.");
    }

    @Test
    @DisplayName("사용자숫자 생성 : 중복된 숫자를 입력받은 경우 예외발생")
    void 사용자숫자_생성_중복된_숫자를_입력받은_경우_예외발생() {
        assertThatThrownBy(() -> player.generateGameNumberList("992"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[오류] 모든 숫자는 서로 같을 수 없습니다.");
    }

    @Test
    @DisplayName("사용자숫자 생성 : 정해진 개수보다 많은 숫자를 입력받은 경우 예외발생")
    void 사용자숫자_생성_정해진_개수보다_많은_숫자를_입력받은_경우_예외발생() {
        assertThatThrownBy(() -> player.generateGameNumberList("4567"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[오류] 숫자의 개수는 3개입니다.");
    }
}
