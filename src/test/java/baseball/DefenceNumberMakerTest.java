package baseball;

import static baseball.utils.Constant.GAME_NUMBER_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.DefenceNumberMaker;
import baseball.utils.ValidationNumber;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class DefenceNumberMakerTest {

    @Test
    void 중복되지_않는지_확인() {
        DefenceNumberMaker defenceNumberMaker = new DefenceNumberMaker();
        List<Integer> defenceNumberList = defenceNumberMaker.getDefenceNumber();

        Set<Integer> result = new HashSet<>(defenceNumberList);

        assertThat(result.size()).isEqualTo(GAME_NUMBER_SIZE);
    }

    @Test
    void 주어진_크기와_일치하는지_확인() {
        DefenceNumberMaker defenceNumberMaker = new DefenceNumberMaker();
        List<Integer> defenceNumberList = defenceNumberMaker.getDefenceNumber();

        assertThat(defenceNumberList.size()).isEqualTo(GAME_NUMBER_SIZE);
    }

    @Test
    void 만들어진_수가_조건에_부합하는지_확인() {
        DefenceNumberMaker defenceNumberMaker = new DefenceNumberMaker();
        List<Integer> defenceNumberList = defenceNumberMaker.getDefenceNumber();

        StringBuilder sb = new StringBuilder();
        for(Integer defenceNumber : defenceNumberList) {
            sb.append(defenceNumber);
        }

        ValidationNumber validationNumber = new ValidationNumber();

        assertThat(validationNumber.checkTotalAndConvertIntegerList(sb.toString()))
                .isEqualTo(defenceNumberList);
    }
}
