package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

@DisplayName("공이 어떤 볼인지 판단하는 Ball 객체 테스트")
public class BallTest {

    @DisplayName("컴퓨터와 사용자가 입력한 숫자가 모두 일치하는 경우 + 모두 일치 할 때에 참을 리턴해야 함")
    @Test
    void givenNumbersEnteredByTheComputerAndTheUser_whenJudgeWhichBallItIs_thenReturnThreeStrikeZeroBall(){
        // Given
        ArrayList<Integer> numbersChosenByTheComputer = new ArrayList<>(List.of(1,2,3));
        ArrayList<Integer> numberSelectedByTheUser = new ArrayList<>(List.of(1,2,3));
        Ball ball1 = new Ball(numbersChosenByTheComputer, numberSelectedByTheUser);

        // When
        ball1.judgeWhichBallItIs();

        // Then
        assertThat(Ball.getStrike()).isEqualTo(3);
        assertThat(Ball.getBall()).isEqualTo(0);
        assertThat(ball1.determineWhetherTheBallIsAStrikeOrABall()).isTrue();
    }

    @DisplayName("컴퓨터와 사용자가 입력한 숫자의 결과가 0스트라이크 2볼인 경우")
    @Test
    void givenNumbersEnteredByTheComputerAndTheUser_whenJudgeWhichBallItIs_thenReturnZeroStrikeTwoBall(){
        // Given
        ArrayList<Integer> numbersChosenByTheComputer = new ArrayList<>(List.of(1,2,3));
        ArrayList<Integer> numberSelectedByTheUser = new ArrayList<>(List.of(3,9,1));
        Ball ball1 = new Ball(numbersChosenByTheComputer, numberSelectedByTheUser);

        // When
        ball1.judgeWhichBallItIs();

        // Then
        assertThat(Ball.getStrike()).isEqualTo(0);
        assertThat(Ball.getBall()).isEqualTo(2);
    }

    @DisplayName("컴퓨터와 사용자가 입력한 숫자의 결과가 1스트라이크 2볼인 경우")
    @Test
    void givenNumbersEnteredByTheComputerAndTheUser_whenJudgeWhichBallItIs_thenReturnOneStrikeTwoBall(){
        // Given
        ArrayList<Integer> numbersChosenByTheComputer = new ArrayList<>(List.of(1,2,3));
        ArrayList<Integer> numberSelectedByTheUser = new ArrayList<>(List.of(3,2,1));
        Ball ball1 = new Ball(numbersChosenByTheComputer, numberSelectedByTheUser);

        // When
        ball1.judgeWhichBallItIs();

        // Then
        assertThat(Ball.getStrike()).isEqualTo(1);
        assertThat(Ball.getBall()).isEqualTo(2);
    }

    @DisplayName("컴퓨터와 사용자가 입력한 숫자의 결과가 0스트라이크 1볼인 경우")
    @Test
    void givenNumbersEnteredByTheComputerAndTheUser_whenJudgeWhichBallItIs_thenReturnZeroStrikeOneBall(){
        // Given
        ArrayList<Integer> numbersChosenByTheComputer = new ArrayList<>(List.of(1,2,3));
        ArrayList<Integer> numberSelectedByTheUser = new ArrayList<>(List.of(4,1,5));
        Ball ball1 = new Ball(numbersChosenByTheComputer, numberSelectedByTheUser);

        // When
        ball1.judgeWhichBallItIs();

        // Then
        assertThat(Ball.getStrike()).isEqualTo(0);
        assertThat(Ball.getBall()).isEqualTo(1);
    }

    @DisplayName("컴퓨터와 사용자가 입력한 숫자의 결과가 0스트라이크 0볼인 경우 `낫싱`")
    @Test
    void givenNumbersEnteredByTheComputerAndTheUser_whenJudgeWhichBallItIs_thenReturnZeroStrikeZeroBall(){
        // Given
        ArrayList<Integer> numbersChosenByTheComputer = new ArrayList<>(List.of(1,2,3));
        ArrayList<Integer> numberSelectedByTheUser = new ArrayList<>(List.of(4,5,6));
        Ball ball1 = new Ball(numbersChosenByTheComputer, numberSelectedByTheUser);

        // When
        ball1.judgeWhichBallItIs();

        // Then
        assertThat(Ball.getStrike()).isEqualTo(0);
        assertThat(Ball.getBall()).isEqualTo(0);
    }

    @DisplayName("스트라이크 또는 볼이 0이 아닌 경우 거짓을 리턴해서 계속 게임을 지속하도록 해야 함")
    @Test
    void givenNumbersEnteredByTheComputerAndTheUser_whenJudgeWhichBallItIs_thenReturnDetermineWhetherTheBallIsStrikeOrABall(){
        // Given
        ArrayList<Integer> numbersChosenByTheComputer = new ArrayList<>(List.of(1,2,3));
        ArrayList<Integer> numberSelectedByTheUser = new ArrayList<>(List.of(4,2,3));
        Ball ball1 = new Ball(numbersChosenByTheComputer, numberSelectedByTheUser);

        // When
        ball1.judgeWhichBallItIs();

        // Then
        assertThat(ball1.determineWhetherTheBallIsAStrikeOrABall()).isFalse();
    }
}
