package study;

import baseball.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserStringCustomTest {

    Game game = new Game();

    public HashMap<String, Integer> 스트라이크_볼_갯수_메서드(List <Integer> computer, HashMap<String, Integer> strikeAndBallCount, List<Integer> userAnswer) {
        for (int i = 0; i < 3; i++) {
            if (computer.contains(userAnswer.get(i))
                    && (userAnswer.get(i).equals(computer.get(i)))) {
                strikeAndBallCount.put("Strike", strikeAndBallCount.get("Strike") + 1);
            } else if (computer.contains(userAnswer.get(i))
                    && (!userAnswer.get(i).equals(computer.get(i)))) {
                strikeAndBallCount.put("Ball", strikeAndBallCount.get("Ball") + 1);
            }
        }
        return strikeAndBallCount;
    }

    /**
     * JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
     */

    @Test
    void 사용자가_입력받은_수를_String에서_List_Integer로_데이터_타입_변환() {
        String input = "321";
        List<Integer> integers = new ArrayList<>();

        assertThat(game.stringToListInteger(input).getClass().getName()).isEqualTo(integers.getClass().getName());
        assertThat(new ArrayList<>()).isInstanceOf(List.class);
    }

    @Test
    void 입력_값에_숫자가_아닌_값이_포함되어_있는_경우() {
        String userAnswer = "2@3";
        assertThat(!userAnswer.matches("[+-]?\\d*(\\.\\d+)?")).isEqualTo(true);
    }

    @Test
    void 입력_값에_1에서_9가_아닌_0이_포함되어_있는_경우() {
        String userAnswer = "103";
        Throwable throwableWithMessage = new IllegalArgumentException(userAnswer);
        assertThat(throwableWithMessage).hasMessageContaining("0");
    }

    @Test
    void 입력_값이_3자리_수가_아닌_경우() {
        String userAnswer = "13";
        List<Integer> answerList = game.stringToListInteger(userAnswer);
        assertThat(answerList.size()).isNotEqualTo(3);
    }

    @Test
    void 입력_값이_서로_다른_숫자가_아닌_경우() {
        String userAnswer1 = "131";
        HashSet<Character> answerList = new HashSet<Character>();
        for (int i = 0; i < userAnswer1.length(); i++) {
            answerList.add(userAnswer1.charAt(i));
        } assertThat(answerList.size()).isNotEqualTo(3);

        String userAnswer2 = "111";
        answerList = new HashSet<Character>();
        for (int i = 0; i < userAnswer2.length(); i++) {
            answerList.add(userAnswer2.charAt(i));
        } assertThat(answerList.size()).isNotEqualTo(3);
    }

    @Test
    void 스트라이크_볼_갯수_계산_테스트() {
        List<Integer> computer = new ArrayList<>();
        computer.add(1);
        computer.add(3);
        computer.add(5);

        List<Integer> userAnswer = new ArrayList<>();
        userAnswer.add(1);
        userAnswer.add(5);
        userAnswer.add(9);

        HashMap<String, Integer> strikeAndBallCount = new HashMap<>();

        strikeAndBallCount.put("Strike", 0);
        strikeAndBallCount.put("Ball", 0);

        HashMap<String, Integer> 스트라이크_볼_갯수 = 스트라이크_볼_갯수_메서드(computer, strikeAndBallCount, userAnswer);
        assertThat(스트라이크_볼_갯수.get("Strike")).isEqualTo(1);
        assertThat(스트라이크_볼_갯수.get("Ball")).isEqualTo(1);
    }
}