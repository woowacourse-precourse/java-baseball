package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {

    @Test
    @DisplayName("String을 Answer로 정상적으로 변환되는지 확인한다.")
    void 정답생성_테스트() {
        // given
        String firstBallNumberString = "1";
        String secondBallNumberString = "2";
        String thirdBallNumberString = "3";

        String totalBallNumberString = firstBallNumberString + secondBallNumberString + thirdBallNumberString;

        // when
        Answer answer = Answer.fromString(totalBallNumberString);
        List<Ball> balls = answer.getBalls();

        //then
        assertThat(balls)
                .hasSize(Answer.ANSWER_SIZE);

        공_정상_생성여부_테스트(balls.get(0), 1, Integer.parseInt(firstBallNumberString));
        공_정상_생성여부_테스트(balls.get(1), 2, Integer.parseInt(secondBallNumberString));
        공_정상_생성여부_테스트(balls.get(2), 3, Integer.parseInt(thirdBallNumberString));
    }

    private void 공_정상_생성여부_테스트(Ball ball, int ballPosition, int ballNumber) {
        assertThat(ball.position()).as("공 위치 값이 일치하는지 확인")
                .isEqualTo((ballPosition));

        assertThat(ball.number()).as("공 숫자 값이 일치하는지 확인")
                .isEqualTo(ballNumber);
    }

    @Nested
    @DisplayName("정답 생성 유효성을 검증한다.")
    class 유효성_검증 {
        @Test
        @DisplayName("정답의 값이 모두 1~9 사이의 양의 정수에 속한다.")
        void 양의_정수() {
            // given
            Answer answer = Answer.create();

            int expectedMinValue = 1;
            int expectedMaxValue = 9;

            //then
            for (int ballPosition = BallPosition.MIN_POSITION; ballPosition <= Answer.ANSWER_SIZE; ballPosition++) {
                Ball ball = answer.getBallByPosition(
                        BallPosition.from(ballPosition)
                );

                assertThat(ball.number() >= expectedMinValue && ball.number() <= expectedMaxValue)
                        .isTrue();
            }
        }

        @Test
        @DisplayName("정답의 길이는 3이다.")
        void 정답_개수_3() {
            // given
            Answer answer = Answer.create();
            int answerSize = answer.getBalls().size();

            int expectedSize = 3;

            //then
            assertThat(answerSize).isEqualTo(expectedSize);
        }

        @Test
        @DisplayName("정답은 서로 다른 숫자로 이루어져있다.")
        void 정답_중복_체크() {
            // given
            Answer answer = Answer.create();
            List<Integer> ballValueList = answer.getBallNumberValues();
            Set<Integer> ballValueSet = new HashSet<>(ballValueList);

            //then
            assertThat(ballValueSet).as("List->Set 변환시 사이즈의 변화 여부를 통해 중복값 존재 여부 확인")
                    .hasSameSizeAs(ballValueList);
        }
    }

}
