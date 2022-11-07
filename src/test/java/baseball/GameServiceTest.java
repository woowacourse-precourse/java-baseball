package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.service.GameService;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameServiceTest {
    GameService gameService;
    Method countingStrikeMethod;
    Method countingContainAnswerMethod;
    Method countingBallMethod;
    Method printHintMethod;

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void init() throws Exception {
        gameService = new GameService();

        countingStrikeMethod = GameService.class
                .getDeclaredMethod("countingStrike", List.class, List.class);
        countingContainAnswerMethod = GameService.class
                .getDeclaredMethod("countingContainAnswer", List.class, List.class);
        countingBallMethod = GameService.class
                .getDeclaredMethod("countingBall", int.class, int.class);
        printHintMethod = GameService.class
                .getDeclaredMethod("printHint", int.class, int.class);

        countingStrikeMethod.setAccessible(true);
        countingContainAnswerMethod.setAccessible(true);
        countingBallMethod.setAccessible(true);
        printHintMethod.setAccessible(true);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    void 스트라이크가_0_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1, 3, 5);
        List<Integer> inputList = List.of(2, 4, 7);

        int predictStrike = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        assertThat(predictStrike).isEqualTo(0);
    }

    @Test
    void 스트라이크가_1_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1, 3, 5);
        List<Integer> inputList = List.of(1, 4, 7);

        int predictStrike = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        assertThat(predictStrike).isEqualTo(1);
    }

    @Test
    void 스트라이크가_2_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1, 3, 5);
        List<Integer> inputList = List.of(1, 3, 7);

        int predictStrike = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        assertThat(predictStrike).isEqualTo(2);
    }

    @Test
    void 스트라이크가_3_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1, 3, 5);
        List<Integer> inputList = List.of(1, 3, 5);

        int predictStrike = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        assertThat(predictStrike).isEqualTo(3);
    }

    @Test
    void 볼이_0_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1, 3, 5);
        List<Integer> inputList = List.of(7, 2, 4);

        int containCount = (int) countingContainAnswerMethod.invoke(gameService, answerList, inputList);
        int strikeCount = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        int predictBall = (int) countingBallMethod.invoke(gameService, containCount, strikeCount);

        assertThat(predictBall).isEqualTo(0);
    }

    @Test
    void 볼이_1_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1, 3, 5);
        List<Integer> inputList = List.of(2, 1, 7);

        int containCount = (int) countingContainAnswerMethod.invoke(gameService, answerList, inputList);
        int strikeCount = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        int predictBall = (int) countingBallMethod.invoke(gameService, containCount, strikeCount);

        assertThat(predictBall).isEqualTo(1);
    }

    @Test
    void 볼이_2_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1, 3, 5);
        List<Integer> inputList = List.of(3, 1, 7);

        int containCount = (int) countingContainAnswerMethod.invoke(gameService, answerList, inputList);
        int strikeCount = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        int predictBall = (int) countingBallMethod.invoke(gameService, containCount, strikeCount);

        assertThat(predictBall).isEqualTo(2);
    }

    @Test
    void 볼이_3_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1, 3, 5);
        List<Integer> inputList = List.of(5, 1, 3);

        int containCount = (int) countingContainAnswerMethod.invoke(gameService, answerList, inputList);
        int strikeCount = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        int predictBall = (int) countingBallMethod.invoke(gameService, containCount, strikeCount);

        assertThat(predictBall).isEqualTo(3);
    }

    @Test
    void 출력테스트_볼만_존재할_경우() throws Exception {
        printHintMethod.invoke(gameService, 1, 0);
        assertThat("1볼").isEqualTo(outContent.toString().trim());
    }

    @Test
    void 출력테스트_스트라이크만_존재할_경우() throws Exception {
        printHintMethod.invoke(gameService, 0, 1);
        assertThat("1스트라이크").isEqualTo(outContent.toString().trim());
    }

    @Test
    void 출력테스트_스트라이크와_볼이_같이_존재할_경우() throws Exception {
        printHintMethod.invoke(gameService, 2, 1);
        assertThat("2볼 1스트라이크").isEqualTo(outContent.toString().trim());
    }

    @Test
    void 출력테스트_스트라이크와_볼이_존재하지않을_경우() throws Exception {
        printHintMethod.invoke(gameService, 0, 0);
        assertThat("낫싱").isEqualTo(outContent.toString().trim());
    }
}
