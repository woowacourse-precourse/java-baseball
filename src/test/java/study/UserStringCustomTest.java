package study;

import baseball.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class UserStringCustomTest {

    Game game = new Game();

    List<Integer> String을_List로_변환하는_메서드(String userAnswer) {
        return Arrays.stream(userAnswer.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

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
    void 입력_값에_숫자가_아닌_값이_포함되어_있는_경우() {
        String userAnswer = "!23";
        assertThat(!userAnswer.matches("[+-]?\\d*(\\.\\d+)?")).isEqualTo(true); {
            throw new IllegalArgumentException("입력 값에 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    @Test
    void 입력_값에_1에서_9가_아닌_0이_포함되어_있는_경우() {
        String userAnswer = "103";
        assertThat(userAnswer.contains("0")).isEqualTo(true); {
            throw new IllegalArgumentException("입력 값에 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    @Test
    void 입력_값이_3자리_수가_아닌_경우() {
        String userAnswer = "13";
        List<Integer> answerList = String을_List로_변환하는_메서드(userAnswer);
        assertThat(answerList.size()).isNotEqualTo(3);
    }


    @Test
    private void incorrectUserAnswerDuplicate(String userAnswer) {
        HashSet<Character> answerList = new HashSet<Character>();
        for (int i = 0; i < userAnswer.length(); i++) {
            answerList.add(userAnswer.charAt(i));
        } if (answerList.size() != 3) {
            throw new IllegalArgumentException("입력 값은 서로 다른 숫자이어야 합니다.");
        }
    }
}