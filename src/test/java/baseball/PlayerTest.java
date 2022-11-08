package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class PlayerTest {
    Player player;
    CheckException check;

    @BeforeEach
    void setUp() {
        player = new Player();
        check = new CheckException();
    }

    @ParameterizedTest
    @DisplayName("잘못된 입력이 들어왔을 때 IllegalArgumentException 예외 테스트")
    @ValueSource(strings = {"abc", "122", "a12", "133", "1224", "a1", "012"})
    void testWithValueSource(String stringArg) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> player.decideNumbers(stringArg));
    }

    @Test
    @DisplayName("플레이어가 입력한 숫자를 확인하는 테스트")
    void testWithPlayerSource() {
        player.decideNumbers("456");
        assertThat(player.getNumbers())
                .as("플레이어는 456을 고르지 않았습니다")
                .containsExactly(4, 5, 6);
    }

    @Test
    @DisplayName("플레이어가 입력한 숫자길이가 정확한지 테스트")
    void testWithPlayerSourceLength() {
        player.decideNumbers("456");
        assertThat(player.getNumbers().size())
                .as("숫자길이가 3이  아닙니다.")
                .isEqualTo(GameStatus.MAX_SIZE.getValue());
    }

    @ParameterizedTest
    @DisplayName("플레이어가 게임 지속 여부에 대한 IllegalArgumentException 예외 테스트")
    @ValueSource(strings = {"12", "a", "b", "!", "#", "3"})
    void testWithGameStatusDataFail(String stringArg) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> check.validateGameStatusData(stringArg));
    }

    @ParameterizedTest
    @DisplayName("플레이어가 게임 지속 여부에 대한 1또는 2 입력 테스트")
    @ValueSource(strings = {"1", "2"})
    void testWithGameStatusDataSuccess(String stringArg) {
        assertThat(check.validateGameStatusData(stringArg)).isIn(1, 2);
    }
}
