package baseball.gameTest;

import baseball.game.Game;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static baseball.game.Game.*;
import static baseball.game.Option.COUNT_BALL;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    void makeRandomNumbersTest(){
        Game game = new Game();
        Set<Integer> result = Sets.newHashSet(computerNumbers);
        assertThat(result.size()).isEqualTo(COUNT_BALL);
    }

    @Test
    void setUserNumberTest(){
        setUserNumber("123");
        assertThat(userNumbers).containsExactly(1,2,3);
    }
}
