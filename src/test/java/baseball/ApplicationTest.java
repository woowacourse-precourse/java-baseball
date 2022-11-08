package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
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

    @Test
    void Ball테스트() {
        Game game = new Game();
        List<Integer> gameAnswer = game.getGameAnswer();
        // Ball : 2
        List<Integer> guessOneCorrect = new ArrayList<>();
        // Ball : 0 (정답과 같으므로)
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
        assertThat(hint.ball).isEqualTo(2);

        // 이전 결과 초기화
        hint.ball = 0;
        game.guessNumber = pseudoAnswer;
        hint.compareAnswer(game);
        assertThat(hint.ball).isZero();
    }

    @Test
    void 결과출력테스트() {
        Game game = new Game();
        List<Integer> gameAnswer = game.getGameAnswer();
        // Ball : 2
        List<Integer> guessOneCorrect = new ArrayList<>();
        // Ball : 0 (정답과 같으므로)
        List<Integer> pseudoAnswer = new ArrayList<>();

        for (int number = 0; number < gameAnswer.size(); number++) {
            // 모든 3자리 숫자가 똑같다.
            pseudoAnswer.add(gameAnswer.get(number));
            // 가운데 숫자만 똑같다. (역순)
            guessOneCorrect.add(gameAnswer.get(2 - number));
        }

        Hint hint = new Hint();
        // 1스트라이크 2볼
        game.guessNumber = guessOneCorrect;
        hint.compareAnswer(game);
        assertThat(hint.getResult()).isEqualTo("2볼 1스트라이크");
        hint.showResult();

        // 이전 결과 초기화
        hint.strike = 0;
        hint.ball = 0;

        // 3스트라이크
        game.guessNumber = pseudoAnswer;
        hint.compareAnswer(game);
        assertThat(hint.getResult()).isEqualTo("3스트라이크");
        hint.showResult();
    }

    @Test
    void 유저입력유효성검사테스트0포함() {
        try {
            Game game = new Game();
            game.validInputValue("205");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("0을 제외한 1~9 사이의 겹치지 않는 3자리의 숫자를 입력해주세요.", e.getMessage());
        }

    }

    @Test
    void 유저입력유효성검사테스트2자리() {
        try {
            Game game = new Game();
            game.validInputValue("15");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("3자리의 1~9 사이의 겹치지 않는 숫자를 입력해주세요.", e.getMessage());
        }

    }

    @Test
    void 유저입력유효성검사테스트문자() {
        try {
            Game game = new Game();
            game.validInputValue("asd");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("1~9 사이의 겹치지 않는 3자리의 숫자를 입력해주세요.", e.getMessage());
        }

    }

    @Test
    void 유저입력유효성검사테스트겹치는숫자() {
        try {
            Game game = new Game();
            game.validInputValue("233");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("겹치지 않는 1~9 사이의 3자리 숫자를 입력해주세요.", e.getMessage());
        }

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

