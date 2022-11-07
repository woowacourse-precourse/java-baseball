package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static baseball.message.GameProgressMessage.END;
import static baseball.message.GameProgressMessage.RESTART;
import static baseball.message.ResultMessage.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

@DisplayName("게임 진행 서비스 테스트")
class ProgressServiceTest {

    final static ProgressService progressService = new ProgressService();
    final static MockedStatic<Randoms> mock = mockStatic(Randoms.class);

    @BeforeEach
    void setProgressService() {
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(1, 2, 3);
        progressService.initProgress();
    }

    @Nested
    @DisplayName("게임 종료 분기점 테스트")
    class getResultOfEndGame {
        @Test
        @DisplayName("1 입력 시 재시작코드 반환")
        void case1() {
            String userInput = "1";
            assertEquals(progressService.getResultOfEndGame(userInput), RESTART);
        }

        @Test
        @DisplayName("2 입력 시 종료코드 반환")
        void case2() {
            String userInput = "2";
            assertEquals(progressService.getResultOfEndGame(userInput), END);
        }

        @Test
        @DisplayName("형식에 맞지 않을 시 예외발생")
        void case3() {
            String userInput = "111";
            assertThrows(IllegalArgumentException.class, () -> {
                progressService.getResultOfEndGame(userInput);
            });
        }

        @Test
        @DisplayName("형식에 맞지 않을 시 예외발생")
        void case4() {
            String userInput = "3";
            assertThrows(IllegalArgumentException.class, () -> {
                progressService.getResultOfEndGame(userInput);
            });
        }
    }

    @Nested
    @DisplayName("올바른 메시지가 나오는지 검증")
    class getResultMessageOfGuessNumber {
        @Test
        @DisplayName("123-123 3스트라이크")
        void case1() {
            String result = progressService.getResultMessageOfGuessNumber("123");
            assertEquals(result, STRIKE.of(3));
        }

        @Test
        @DisplayName("123-234 2볼")
        void case2() {
            String result = progressService.getResultMessageOfGuessNumber("234");
            assertEquals(result, BALL.of(2));
        }

        @Test
        @DisplayName("123-789 낫싱")
        void case3() {
            String result = progressService.getResultMessageOfGuessNumber("789");
            assertEquals(result, NOTHING.getMessage());
        }
    }

    @Nested
    @DisplayName("게임이 종료되었는지 구분")
    class isEnd {
        @Test
        @DisplayName("123-123 3스트라이크 발생 시 게임 종료")
        void case1() {
            progressService.getResultMessageOfGuessNumber("123");
            assertTrue(progressService.isEnd());
        }

        @Test
        @DisplayName("123-234 2볼 발생 시 게임 종료안함")
        void case2() {
            progressService.getResultMessageOfGuessNumber("234");
            assertFalse(progressService.isEnd());
        }

        @Test
        @DisplayName("123-789 낫싱 발생 시 게임 종료안함")
        void case3() {
            progressService.getResultMessageOfGuessNumber("789");
            assertFalse(progressService.isEnd());
        }
    }

}