package baseball;

import baseball.exception.ExceptionCode;
import baseball.exception.GameException;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class RestartOrEndGameTest {
    @Test
    void 예외_테스트() {
        //given
        String input = "f1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean isCorrectAnswer = true;
        //when
        Throwable throwable = catchThrowable(() -> {
            boolean isReStart = restartOrEndGame(isCorrectAnswer);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(GameException.class);
    }
    @Test
    void 새로시작_테스트() {
        //given
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean isCorrectAnswer = true;
        //when
        boolean isReStart = restartOrEndGame(isCorrectAnswer);

        //then
        assertThat(isReStart)
                .isEqualTo(true);
    }
    @Test
    void 종료_테스트() {
        //given
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean isCorrectAnswer = true;
        //when
        boolean isReStart = restartOrEndGame(isCorrectAnswer);

        //then
        assertThat(isReStart)
                .isEqualTo(false);
    }

    public boolean restartOrEndGame(boolean isCorrectAnswer) {
        if(!isCorrectAnswer) return false;

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        while(true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();

            if(input.equals("1")) {
                return true;
            } else if(input.equals("2")) {
                return false;
            } else {
                throw new GameException(ExceptionCode.INPUT_NOT_VALID);
            }
        }
    }
}
