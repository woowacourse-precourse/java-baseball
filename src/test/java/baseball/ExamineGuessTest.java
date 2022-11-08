package baseball;

import baseball.gameComponents.GameComponent;
import baseball.gameComponents.Validator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExamineGuessTest {
    private Validator validator = new Validator();
    private GameComponent gameComponent = new GameComponent(validator);
    @Test
    void 정답인_경우() {
        //given
        List<Integer> guess = List.of(1, 2, 3);
        List<Integer> answer = List.of(1, 2, 3);
        //when
        int[] actual = gameComponent.examineGuess(guess, answer);
        //then
        assertThat(actual)
                .isEqualTo(new int[] {0, 3});
    }

    @Test
    void Strikes_Only_경우() {
        //given
        List<Integer> guess = List.of(1, 2, 0);
        List<Integer> answer = List.of(1, 2, 3);
        //when
        int[] actual = gameComponent.examineGuess(guess, answer);
        //then
        assertThat(actual)
                .isEqualTo(new int[] {0, 2});
    }

    @Test
    void Balls_Only_경우() {
        //given
        List<Integer> guess = List.of(1, 2, 0);
        List<Integer> answer = List.of(2, 0, 1);
        //when
        int[] actual = gameComponent.examineGuess(guess, answer);
        //then
        assertThat(actual)
                .isEqualTo(new int[] {3, 0});
    }

    @Test
    void Balls_Only_경우2() {
        //given
        List<Integer> guess = List.of(1, 2, 0);
        List<Integer> answer = List.of(2, 6, 1);
        //when
        int[] actual = gameComponent.examineGuess(guess, answer);
        //then
        assertThat(actual)
                .isEqualTo(new int[] {2, 0});
    }
    @Test
    void Balls_Strikes_경우() {
        //given
        List<Integer> guess = List.of(2, 1, 6);
        List<Integer> answer = List.of(2, 6, 1);
        //when
        int[] actual = gameComponent.examineGuess(guess, answer);
        //then
        assertThat(actual)
                .isEqualTo(new int[]{2, 1});
    }
}
