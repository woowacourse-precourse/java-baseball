package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class DefenceNumberMakerTest {

    private static final int SIZE = 3;

    @Test
    void 중복되지_않는지_확인() {
        DefenceNumberMaker defenceNumberMaker = new DefenceNumberMaker(3);
        List<Integer> defenceNumberList = defenceNumberMaker.getDefenceNumber();

        Set<Integer> result = new HashSet<>(defenceNumberList);

        assertThat(result.size()).isEqualTo(SIZE);
    }

    @Test
    void 주어진_크기와_일치하는지_확인() {
        DefenceNumberMaker defenceNumberMaker = new DefenceNumberMaker(3);
        List<Integer> defenceNumberList = defenceNumberMaker.getDefenceNumber();

        assertThat(defenceNumberList.size()).isEqualTo(SIZE);
    }
}
