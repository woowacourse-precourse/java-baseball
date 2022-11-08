package FunctionTest;

import baseball.Player;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class GameTest {
    @Test
    void 플레이어_숫자_확인(){
        Player player = new Player();
        System.out.println(player.getInput());
    }
}
