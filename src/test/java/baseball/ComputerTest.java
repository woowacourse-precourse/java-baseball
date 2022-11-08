package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void randomNumber() {
        String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
        String[] oneDigitNumber = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        assertThat(oneDigitNumber).contains(randomNumber);
    }

    @Test
    void checkNumber() {
        Integer number = 3;
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2));
        Boolean answer = numberList.contains(number);
        assertThat(answer).isEqualTo(false);
    }

    @Test
    void addNumber() {
        Integer answer = 3;
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2));
        numberList.add(answer);
        assertThat(numberList.get(2)).isEqualTo(answer);
    }

    @Test
    void madeNumber() {
        ArrayList<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        assertThat(numberList.size()).isEqualTo(3);

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if (!answer.contains(numberList.get(i))) {
                answer.add(numberList.get(i));
            }
        }
        assertThat(answer).isEqualTo(numberList);
    }

    @Test
    void setNumber() {
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3));
        Integer answer = numberList.get(0) * 100 + numberList.get(1) * 10 + numberList.get(2);
        assertThat(answer).isEqualTo(123);
    }

    @Test
    void madeAnswer() {
        madeNumber();
        setNumber();
    }
}