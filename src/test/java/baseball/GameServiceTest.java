package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.User;
import baseball.service.GameService;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameServiceTest {
    GameService gameService;
    Method countingStrikeMethod;
    Method countingContainAnswerMethod;
    Method countingBallMethod;

    @BeforeEach
    void init() throws Exception{
        gameService = new GameService();

        countingStrikeMethod = GameService.class.getDeclaredMethod("countingStrike", List.class, List.class);
        countingContainAnswerMethod = GameService.class.getDeclaredMethod("countingContainAnswer", List.class, List.class);
        countingBallMethod = GameService.class.getDeclaredMethod("countingBall", int.class, int.class);

        countingStrikeMethod.setAccessible(true);
        countingContainAnswerMethod.setAccessible(true);
        countingBallMethod.setAccessible(true);
    }

    @Test
    void 스트라이크가_0_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1,3,5);
        List<Integer> inputList = List.of(2,4,7);

        int predictStrike = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        assertThat(predictStrike).isEqualTo(0);
    }

    @Test
    void 스트라이크가_1_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1,3,5);
        List<Integer> inputList = List.of(1,4,7);

        int predictStrike = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        assertThat(predictStrike).isEqualTo(1);
    }

    @Test
    void 스트라이크가_2_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1,3,5);
        List<Integer> inputList = List.of(1,3,7);

        int predictStrike = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        assertThat(predictStrike).isEqualTo(2);
    }

    @Test
    void 스트라이크가_3_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1,3,5);
        List<Integer> inputList = List.of(1,3,5);

        int predictStrike = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        assertThat(predictStrike).isEqualTo(3);
    }

    @Test
    void 볼이_0_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1,3,5);
        List<Integer> inputList = List.of(7,2,4);

        int containCount = (int) countingContainAnswerMethod.invoke(gameService, answerList, inputList);
        int strikeCount = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        int predictBall = (int) countingBallMethod.invoke(gameService, containCount, strikeCount);

        assertThat(predictBall).isEqualTo(0);
    }

    @Test
    void 볼이_1_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1,3,5);
        List<Integer> inputList = List.of(2,1,7);

        int containCount = (int) countingContainAnswerMethod.invoke(gameService, answerList, inputList);
        int strikeCount = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        int predictBall = (int) countingBallMethod.invoke(gameService, containCount, strikeCount);

        assertThat(predictBall).isEqualTo(1);
    }

    @Test
    void 볼이_2_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1,3,5);
        List<Integer> inputList = List.of(3,1,7);

        int containCount = (int) countingContainAnswerMethod.invoke(gameService, answerList, inputList);
        int strikeCount = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        int predictBall = (int) countingBallMethod.invoke(gameService, containCount, strikeCount);

        assertThat(predictBall).isEqualTo(2);
    }

    @Test
    void 볼이_3_나오는_경우() throws Exception {
        List<Integer> answerList = List.of(1,3,5);
        List<Integer> inputList = List.of(5,1,3);

        int containCount = (int) countingContainAnswerMethod.invoke(gameService, answerList, inputList);
        int strikeCount = (int) countingStrikeMethod.invoke(gameService, answerList, inputList);
        int predictBall = (int) countingBallMethod.invoke(gameService, containCount, strikeCount);

        assertThat(predictBall).isEqualTo(3);
    }
}
