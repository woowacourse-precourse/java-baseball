package baseball.domain;

import static baseball.global.exception.CustomException.INVALID_GAME_FLAG;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameStarterTest {


    @Test
    @DisplayName("Game 재시작 or Game 종료 플래그 1 또는 2 입력이 아닐 경우")
    void validateGameFlag_When_Game_Flag_Is_Not_1_OR_2_Then_Throw_Exception() {
        // Given & When
        String testUserGameFlag = "3";

        // Then
        assertThatThrownBy(() -> BaseballGameStarter.testBaseballGame(testUserGameFlag))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_GAME_FLAG.getMessage());
    }
}
