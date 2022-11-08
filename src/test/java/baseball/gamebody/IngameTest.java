package baseball.gamebody;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class IngameTest {
    @Test
    void 낫싱_여부_테스트() {
        final PlayGame test = new PlayGame();
        final List<String> playerNumber = List.of("1","2","3");
        final List<String> computerNumber = List.of("4","5","6");
        
        assertThat(test.nothing(playerNumber,computerNumber)).isEqualTo(0);
    }

}
