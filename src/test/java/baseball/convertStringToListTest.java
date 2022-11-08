package baseball;

import baseball.gameComponents.GameComponent;
import baseball.gameComponents.Validator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class convertStringToListTest {
    private Validator validator = new Validator();
    private GameComponent gameComponent = new GameComponent(validator);
    @Test
    void 전환_테스트() {
        //given
        String input = "0011";
        //when
        List<Integer> actual = gameComponent.convertStringToList(input);
        //then
        assertThat(actual)
                .isInstanceOf(List.class)
                .isEqualTo(List.of(0, 0, 1, 1));
    }
}
