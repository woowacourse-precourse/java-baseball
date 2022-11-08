package baseball;


import baseball.exception.GameException;
import baseball.gameComponents.GameComponent;
import baseball.gameComponents.Validator;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class ExamineResultAndPrintTest {
    private Validator validator = new Validator();
    private GameComponent gameComponent = new GameComponent(validator);


    @Test
    void 예외_초과_test() {
        //given
        int[] input = new int[] {0, 5};
        //when
        Throwable throwable = catchThrowable(() -> {
            boolean actual = printExamineResult(input);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(GameException.class);
    }

    @Test
    void 예외_음수_test() {
        //given
        int[] input = new int[] {-1, 3};
        //when
        Throwable throwable = catchThrowable(() -> {
            boolean actual = printExamineResult(input);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(GameException.class);
    }
    @Test
    void 낫싱_test() {
        //출력값 테스트위한 설정
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //given
        int[] input = new int[] {0, 0};
        //when
        boolean actual = printExamineResult(input);
        //then
        assertThat(actual)
                .isEqualTo(false);
        assertThat(out.toString())
                .isEqualTo("낫싱\n");
    }

    @Test
    void 정답_test() {
        //출력값 테스트위한 설정
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //given
        int[] input = new int[] {0, 3};
        //when
        boolean actual = printExamineResult(input);
        //then
        assertThat(actual)
                .isEqualTo(true);
        assertThat(out.toString())
                .isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    @Test
    void 스크라이크_볼_test() {
        //출력값 테스트위한 설정
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //given
        int[] input = new int[] {1, 2};
        //when
        boolean actual = printExamineResult(input);
        //then
        assertThat(actual)
                .isEqualTo(false);
        assertThat(out.toString())
                .isEqualTo("1볼 2스트라이크\n");
    }
    //[0] : ball
    //[1] : strike
    public boolean printExamineResult(int[] ballsAnsStrikes) {
        return gameComponent.examineResultAndPrint(ballsAnsStrikes);
    }

}
