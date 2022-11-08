package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    @DisplayName("문자열로부터 Balls 객체 생성 테스트")
    void create() {
        String ball1 = "1";
        String ball2 = "2";
        String ball3 = "3";

        String input = ball1 + ball2 + ball3;

        Balls balls = Balls.from(input);
        List<Ball> ballList = balls.getBalls();
        Assertions.assertAll(
                () -> assertThat(ballList.get(0).number()).as("정상 숫자 값").isEqualTo(Integer.parseInt(ball1)),
                () -> assertThat(ballList.get(1).number()).as("정상 숫자 값").isEqualTo(Integer.parseInt(ball2)),
                () -> assertThat(ballList.get(2).number()).as("정상 숫자 값").isEqualTo(Integer.parseInt(ball3)),
                () -> assertThat(ballList.get(0).position()).as("정상 위치 값").isEqualTo(1),
                () -> assertThat(ballList.get(1).position()).as("정상 위치 값").isEqualTo(2),
                () -> assertThat(ballList.get(2).position()).as("정상 위치 값").isEqualTo(3)
        );
    }

    @Nested
    @DisplayName("Balls 생성 유효성을 검증한다.")
    class Validate {
        @Test
        @DisplayName("Ball 모두 1~9 사이의 양의 정수값을 갖는다.")
        void create() {
            Balls balls = Balls.create();
            int minValue = 1;
            int maxValue = 9;
            for (int position = Position.MIN_POSITION; position <= Balls.BALLS_SIZE; position++) {
                Ball ball = balls.getBallByPosition(
                        Position.from(position)
                );
                assertThat(ball.number() >= minValue && ball.number() <= maxValue)
                        .isTrue();
            }
        }

        @Test
        @DisplayName("Balls의 길이는 3이다.")
        void validateSize() {
            Balls balls = Balls.create();
            int BallsSize = balls.getBalls().size();
            int size = 3;
            assertThat(BallsSize).isEqualTo(size);
        }

        @Test
        @DisplayName("중복된 Ball을 갖지 않는다.")
        void validateDuplicate() {
            Balls balls = Balls.create();
            List<Integer> ballValueList = balls.getBallNumbers();
            Set<Integer> ballValueSet = new HashSet<>(ballValueList);
            assertThat(ballValueSet).as("List에서 Set 변환시 사이즈 변화 여부를 통해 중복값 존재 여부 확인")
                    .hasSameSizeAs(ballValueList);
        }
    }
}
