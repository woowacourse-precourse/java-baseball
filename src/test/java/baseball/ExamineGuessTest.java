package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

public class ExamineGuessTest {
    @Test
    void 정답인_경우() {
        //given
        List<Integer> guess = List.of(1, 2, 3);
        List<Integer> answer = List.of(1, 2, 3);
        //when
        int[] actual = examineGuess(guess, answer);
        //then
        assertThat(actual)
                .isEqualTo(new int[] {3, 0});
    }

    @Test
    void Strikes_Only_경우() {
        //given
        List<Integer> guess = List.of(1, 2, 0);
        List<Integer> answer = List.of(1, 2, 3);
        //when
        int[] actual = examineGuess(guess, answer);
        //then
        assertThat(actual)
                .isEqualTo(new int[] {2, 0});
    }

    @Test
    void Balls_Only_경우() {
        //given
        List<Integer> guess = List.of(1, 2, 0);
        List<Integer> answer = List.of(2, 0, 1);
        //when
        int[] actual = examineGuess(guess, answer);
        //then
        assertThat(actual)
                .isEqualTo(new int[] {0, 3});
    }

    @Test
    void Balls_Only_경우2() {
        //given
        List<Integer> guess = List.of(1, 2, 0);
        List<Integer> answer = List.of(2, 6, 1);
        //when
        int[] actual = examineGuess(guess, answer);
        //then
        assertThat(actual)
                .isEqualTo(new int[] {0, 2});
    }
    @Test
    void Balls_Strikes_경우() {
        //given
        List<Integer> guess = List.of(2, 1, 6);
        List<Integer> answer = List.of(2, 6, 1);
        //when
        int[] actual = examineGuess(guess, answer);
        //then
        assertThat(actual)
                .isEqualTo(new int[] {1, 2});
    }


    public int[] examineGuess(List<Integer> guess, List<Integer> answer) {
        //0번째 값 : strike;
        //1번째 값 : ball;
        int[] strikesAndBalls = new int[2];
        boolean[] isPicked = new boolean[10];
        for(int i = 0; i < 3; i++) {
            int guessNumber = guess.get(i);
            int answerNumber = answer.get(i);
            //스트라이크
            if(guessNumber == answerNumber) {
                strikesAndBalls[0]++;
            } else {
                isBall(guessNumber, isPicked, strikesAndBalls);
                isBall(answerNumber, isPicked, strikesAndBalls);
            }
        }
        return strikesAndBalls;
    }

    private void isBall(int input, boolean[] isPicked, int[] strikesAndBalls) {
        if(isPicked[input]) {
            strikesAndBalls[1]++;
        } else {
            isPicked[input] = true;
        }
    }
}
