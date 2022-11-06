package study;

import baseball.Game;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserStringCustomTest {

    Game game = new Game();

    /**
     * JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
     */

    @Test
    void 사용자가_입력받은_수를_String에서_List_Integer로_데이터_타입_변환() {
        String input = "321";
        List<Integer> integers = new ArrayList<>();

        assertThat(game.stringToListInteger(input).getClass().getName()).isEqualTo(integers.getClass().getName());
    }

    @Test
    void incorrectUserAnswerContainNotNumeric() {
        String userAnswer = "!23";
        assertThat(!userAnswer.matches("[+-]?\\d*(\\.\\d+)?")).isEqualTo(true); {
            throw new IllegalArgumentException("입력 값에 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    @Test
    void incorrectUserAnswerContainZero() {
        String userAnswer = "103";
        assertThat(userAnswer.contains("0")).isEqualTo(true); {
            throw new IllegalArgumentException("입력 값에 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}