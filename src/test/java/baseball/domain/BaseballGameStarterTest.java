package baseball.domain;

import static baseball.global.exception.CustomException.INVALID_GAME_FLAG;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.global.constants.Constants.Korean;
import baseball.utils.TestUtils;
import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameStarterTest {


    @Test
    @DisplayName("Game 재시작 or Game 종료 플래그 1 또는 2 입력이 아닐 경우")
    void validateGameFlag_When_Game_Flag_Is_Not_1_OR_2_Then_Throw_Exception() {
        // Given & When
        String testUserGameFlag = "3";
        String testUserGameFlag2 = "99";
        String testUserGameFlag3 = "-1";

        // Then
        assertThatThrownBy(() -> BaseballGameStarter.testBaseballGame(testUserGameFlag))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_GAME_FLAG.getMessage());

        assertThatThrownBy(() -> BaseballGameStarter.testBaseballGame(testUserGameFlag2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_GAME_FLAG.getMessage());

        assertThatThrownBy(() -> BaseballGameStarter.testBaseballGame(testUserGameFlag3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_GAME_FLAG.getMessage());
    }

}
