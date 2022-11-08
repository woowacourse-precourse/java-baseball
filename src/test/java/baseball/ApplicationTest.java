package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임랜덤테스트() {
        Game game = new Game();
        // 세 자리가 다른지 확인하기 위한 리스트
        List<Integer> dupCheck = new ArrayList<>();
        List<Integer> answer = game.getGameRandomNumber();
        // 겹치는 경우를 제외하고 dupCheck 리스트에 원소를 넣는다.
        for (int number : answer) {
            if (!dupCheck.contains(number)) {
                dupCheck.add(number);
            }
        }

        assertThat(answer).isEqualTo(dupCheck);
    }

    @Test
    void 게임생성자테스트() {
        Game game = new Game();

        List<Integer> dupCheck = new ArrayList<>();
        List<Integer> answer = game.getGameAnswer();

        for (int number : answer) {
            if (!dupCheck.contains(number)) {
                dupCheck.add(number);
            }
        }

        assertThat(answer).isEqualTo(dupCheck);
    }

    @Test
    void Strike테스트() {
        Game game = new Game();
        List<Integer> gameAnswer = game.getGameAnswer();
        // Strike : 1
        List<Integer> guessOneCorrect = new ArrayList<>();
        // Strike : 3
        List<Integer> pseudoAnswer = new ArrayList<>();

        for (int number = 0; number < gameAnswer.size(); number++) {
            // 모든 3자리 숫자가 똑같다.
            pseudoAnswer.add(gameAnswer.get(number));
            // 가운데 숫자만 똑같다. (역순)
            guessOneCorrect.add(gameAnswer.get(2 - number));
        }

        Hint hint = new Hint();
        game.guessNumber = guessOneCorrect;
        hint.compareAnswer(game);
        assertThat(hint.strike).isEqualTo(1);

        // initialize
        hint.strike = 0;
        game.guessNumber = pseudoAnswer;
        hint.compareAnswer(game);
        assertThat(hint.strike).isEqualTo(3);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

