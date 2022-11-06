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

    @BeforeEach
    void init(){
        gameService = new GameService();
    }

    @Test
    void 스트라이크가_0_나오는_경우() throws Exception {
        Method method = GameService.class.getDeclaredMethod("countingStrike", List.class, List.class);
        method.setAccessible(true);

        List<Integer> answerList = List.of(1,3,5);
        List<Integer> inputList = List.of(2,4,7);

        int predictStrike = (int) method.invoke(gameService, answerList, inputList);
        assertThat(predictStrike).isEqualTo(0);
    }

    @Test
    void 스트라이크가_1_나오는_경우() throws Exception {
        Method method = GameService.class.getDeclaredMethod("countingStrike", List.class, List.class);
        method.setAccessible(true);

        List<Integer> answerList = List.of(1,3,5);
        List<Integer> inputList = List.of(1,4,7);

        int predictStrike = (int) method.invoke(gameService, answerList, inputList);
        assertThat(predictStrike).isEqualTo(1);
    }

    @Test
    void 스트라이크가_2_나오는_경우() throws Exception {
        Method method = GameService.class.getDeclaredMethod("countingStrike", List.class, List.class);
        method.setAccessible(true);

        List<Integer> answerList = List.of(1,3,5);
        List<Integer> inputList = List.of(1,3,7);

        int predictStrike = (int) method.invoke(gameService, answerList, inputList);
        assertThat(predictStrike).isEqualTo(2);
    }

    @Test
    void 스트라이크가_3_나오는_경우() throws Exception {
        Method method = GameService.class.getDeclaredMethod("countingStrike", List.class, List.class);
        method.setAccessible(true);

        List<Integer> answerList = List.of(1,3,5);
        List<Integer> inputList = List.of(1,3,5);

        int predictStrike = (int) method.invoke(gameService, answerList, inputList);
        assertThat(predictStrike).isEqualTo(3);
    }
}
