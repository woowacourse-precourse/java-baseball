package baseball.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("점수 관련 테스트")
class ScoreServiceTest {

    ScoreService scoreService = new ScoreService(List.of(1,2,3));


    @Nested
    @DisplayName("스트라이크 개수")
    class getStrikeScore {
        @Test
        @DisplayName("123 과 453 - 1스트라이크")
        void case1() {
            int result = scoreService.getStrikeScore(List.of(4,5,3));
            Assertions.assertEquals(result, 1);
        }

        @Test
        @DisplayName("123 과 987 - 0스트라이크")
        void case2() {
            int result = scoreService.getStrikeScore(List.of(987));
            Assertions.assertEquals(result, 0);
        }

        @Test
        @DisplayName("123 과 123 - 3스트라이크")
        void case3() {
            int result = scoreService.getStrikeScore(List.of(1,2,3));
            Assertions.assertEquals(result, 3);
        }
    }

    @Nested
    @DisplayName("볼 개수")
    class getBallScore {
        @Test
        @DisplayName("123 과 321 - 2볼")
        void case1() {
            int result = scoreService.getBallScore(List.of(3,2,1));
            Assertions.assertEquals(result, 2);
        }

        @Test
        @DisplayName("123 과 987 - 0볼")
        void case2() {
            int result = scoreService.getBallScore(List.of(987));
            Assertions.assertEquals(result, 0);
        }

        @Test
        @DisplayName("123 과 123 - 0볼")
        void case3() {
            int result = scoreService.getBallScore(List.of(1,2,3));
            Assertions.assertEquals(result, 0);
        }
    }

    @Nested
    @DisplayName("결과가 낫싱인지")
    class isNothing {

        @Test
        @DisplayName("123과 456")
        void case1() {
            boolean result = scoreService.isNothing(List.of(4,5,6));
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("123과 987")
        void case2() {
            boolean result = scoreService.isNothing(List.of(9,8,7));
            Assertions.assertTrue(result);
        }
    }

}