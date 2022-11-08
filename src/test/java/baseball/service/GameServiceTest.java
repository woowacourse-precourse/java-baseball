package baseball.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class GameServiceTest {
    private static GameService gameService;

    @BeforeEach
    public void beforeEach(){
        gameService = new GameService();
    }

    @Test
    void compareAnswer_정답_맞췄을_경우(){
        // given
        List<Integer> computer = List.of(1,2,3);
        List<Integer> user = List.of(1,2,3);

        // when
        boolean isCompare = gameService.compareAnswer(computer,user);

        // then
        assertThat(isCompare).isEqualTo(true);
    }

    @Test
    void compareAnswer_정답_틀린_경우(){
        List<Integer> computer = List.of(1,2,3);
        List<Integer> user = List.of(1,2,4);

        boolean isCompare = gameService.compareAnswer(computer,user);

        assertThat(isCompare).isEqualTo(false);
    }

}
