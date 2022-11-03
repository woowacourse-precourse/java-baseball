package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Feat1Test {

    @Test
    void 랜덤_생성_숫자_검증(){

        List<Integer> randomNumber = Number.getRandomNumber();

        assertThat(randomNumber.size())
                .isEqualTo(3);
        assertThat(checkDuplicate(randomNumber)).isEqualTo(false);
        assertThat(checkRange(randomNumber)).isEqualTo(false);
    }

    boolean checkDuplicate(List<Integer> number){
        List<Integer> alreadyHaveNumber = new ArrayList<>();
        for (int index = 0; index < number.size(); index++) {
            if (alreadyHaveNumber.contains(number.get(index))) {
                return true;
            }
            alreadyHaveNumber.add(number.get(index));
        }
        return false;
    }

    boolean checkRange(List<Integer> number){
        for (int index = 0; index < number.size(); index++) {
            if (number.contains(0)) {
                return true;
            }
        }
        return false;
    }
}
