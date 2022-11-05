package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void Repeats1000TimesCreateRandomNumber() {
        boolean result = true;

        for(int i = 0; i< 1000; i++) {
            List<Integer> randomNumber = createRandomNumber();
            if(!confirmDuplicationNumber(randomNumber)) {
                result = false;
            }
        }
        assertThat(result).isEqualTo(true);
    }

    boolean confirmDuplicationNumber(List<Integer> number) {
        return (number.get(0) != number.get(1)) && (number.get(1) != number.get(2)) && (number.get(0) != number.get(2));
    }

    List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}