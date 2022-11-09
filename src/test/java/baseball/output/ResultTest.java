package baseball.output;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    public Result result = new Result();

    @Nested
    @DisplayName("3스트라이크 input")
    class three_strike{

        @BeforeEach
        void 선언(){
            result.updateResult(List.of(1,2,3), List.of(1,2,3));
        }

        @Test
        @DisplayName("3스트라이크 결과 확인")
        void 결과(){
            assertThat(result.getResult()).isEqualTo("3스트라이크");
        }

        @Test
        @DisplayName("정답여부 - 정답")
        void 정답여부(){
            assertThat(result.getCorrect()).isTrue();
        }
    }

    @Nested
    @DisplayName("2스트라이크 input")
    class two_strike{

        @BeforeEach
        void 선언(){
            result.updateResult(List.of(1,2,3), List.of(1,2,4));
        }

        @Test
        @DisplayName("2스트라이크 결과 확인")
        void 결과(){
            assertThat(result.getResult()).isEqualTo("2스트라이크");
        }

        @Test
        @DisplayName("정답여부 - 오답")
        void 정답여부(){
            assertThat(result.getCorrect()).isFalse();
        }
    }

    @Nested
    @DisplayName("1스트라이크 input")
    class one_strike{

        @BeforeEach
        void 선언(){
            result.updateResult(List.of(1,5,3), List.of(1,2,4));
        }

        @Test
        @DisplayName("1스트라이크 결과 확인")
        void 결과(){
            assertThat(result.getResult()).isEqualTo("1스트라이크");
        }

        @Test
        @DisplayName("정답여부 - 오답")
        void 정답여부(){
            assertThat(result.getCorrect()).isFalse();
        }
    }

    @Nested
    @DisplayName("1볼 1스트라이크 input")
    class one_ball_one_strike{

        @BeforeEach
        void 선언(){
            result.updateResult(List.of(1,5,3), List.of(1,3,4));
        }

        @Test
        @DisplayName("1볼 1스트라이크 결과 확인")
        void 결과(){
            assertThat(result.getResult()).isEqualTo("1볼 1스트라이크");
        }

        @Test
        @DisplayName("정답여부 - 오답")
        void 정답여부(){
            assertThat(result.getCorrect()).isFalse();
        }
    }


    @Nested
    @DisplayName("2볼 1스트라이크 input")
    class two_ball_one_strike{

        @BeforeEach
        void 선언(){
            result.updateResult(List.of(1,5,3), List.of(1,3,5));
        }

        @Test
        @DisplayName("2볼 1스트라이크 결과 확인")
        void 결과(){
            assertThat(result.getResult()).isEqualTo("2볼 1스트라이크");
        }

        @Test
        @DisplayName("정답여부 - 오답")
        void 정답여부(){
            assertThat(result.getCorrect()).isFalse();
        }
    }

    @Nested
    @DisplayName("3볼 input")
    class three_ball{

        @BeforeEach
        void 선언(){
            result.updateResult(List.of(2,5,3), List.of(5,3,2));
        }

        @Test
        @DisplayName("3볼 결과 확인")
        void 결과(){
            assertThat(result.getResult()).isEqualTo("3볼");
        }

        @Test
        @DisplayName("정답여부 - 오답")
        void 정답여부(){
            assertThat(result.getCorrect()).isFalse();
        }
    }

    @Nested
    @DisplayName("2볼 input")
    class two_ball{

        @BeforeEach
        void 선언(){
            result.updateResult(List.of(2,5,1), List.of(5,3,2));
        }

        @Test
        @DisplayName("2볼 결과 확인")
        void 결과(){
            assertThat(result.getResult()).isEqualTo("2볼");
        }

        @Test
        @DisplayName("정답여부 - 오답")
        void 정답여부(){
            assertThat(result.getCorrect()).isFalse();
        }
    }

    @Nested
    @DisplayName("1볼 input")
    class one_ball{

        @BeforeEach
        void 선언(){
            result.updateResult(List.of(2,7,8), List.of(5,3,2));
        }

        @Test
        @DisplayName("1볼 결과 확인")
        void 결과(){
            assertThat(result.getResult()).isEqualTo("1볼");
        }

        @Test
        @DisplayName("정답여부 - 오답")
        void 정답여부(){
            assertThat(result.getCorrect()).isFalse();
        }
    }

    @Nested
    @DisplayName("낫싱 input")
    class nothing{

        @BeforeEach
        void 선언(){
            result.updateResult(List.of(2,7,8), List.of(1,3,5));
        }

        @Test
        @DisplayName("낫싱 결과 확인")
        void 결과(){
            assertThat(result.getResult()).isEqualTo("낫싱");
        }

        @Test
        @DisplayName("정답여부 - 오답")
        void 정답여부(){
            assertThat(result.getCorrect()).isFalse();
        }
    }
}