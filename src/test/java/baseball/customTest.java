package baseball;

import baseball.Service.Rule;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class customTest {
    @Test
    void test1(){
        Rule rule = new Rule();
        List<Integer> answer = List.of(2,1,3);

        assertThat( rule.ball(answer,1,0)).isEqualTo(1);
    }
}
