package util;

import baseball.game.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputTest {

    @Test
    @DisplayName("입력값 List<Integer>로 변환")
    void testToList() {
        String readLine = "356";

        List<Integer> listFromInput = Input.makeListFromInput(readLine);

        assertThat(listFromInput).isEqualTo(List.of(3, 5, 6));
    }

    @Nested
    @DisplayName("게임 종료 후 사용자 입력값")
    class testAfterGameOver {
        @Test
        @DisplayName("1을 쓴 경우")
        void testInput1() {
            String readLine = "1";

            GameStatus gameStatus = Input.readLineAfterGame(readLine);
            assertThat(gameStatus).isEqualTo(GameStatus.PROGRESSING);
        }
        @Test
        @DisplayName("2을 쓴 경우")
        void testInput2() {
            String readLine = "2";

            GameStatus gameStatus = Input.readLineAfterGame(readLine);
            assertThat(gameStatus).isEqualTo(GameStatus.EXIT);
        }
        @Test
        @DisplayName("그 외의 숫자를 쓴 경우")
        void testInputOther() {
            String readLine = "135";
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Input.readLineAfterGame(readLine));

        }
    }

}
