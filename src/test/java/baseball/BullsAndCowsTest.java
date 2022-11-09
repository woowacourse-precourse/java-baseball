package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class BullsAndCowsTest {

    BullsAndCows bullsAndCows = new BullsAndCows(new BullsAndCowsResult());

    @Test
    void 중복_문자_확인_여부_테스트() {

        char charArray[] = {'1', '1', '2'};
        assertThat(bullsAndCows.isOverlap(charArray)).isTrue();

        charArray[1] = '3';
        assertThat(bullsAndCows.isOverlap(charArray)).isFalse();
    }

    @Test
    void 문자열_리스트_변환_테스트() {
        List<Integer> result = bullsAndCows.inputToList("123");
        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(2);
        assertThat(result.get(2)).isEqualTo(3);
    }

    @Test
    void 특정숫자_인덱스_체크() {
        List<Integer> userInputNumber = new ArrayList<>();
        userInputNumber.add(10);
        userInputNumber.add(20);
        userInputNumber.add(30);

        int numberIndex = bullsAndCows.findNumberIndex(userInputNumber, 20);
        assertThat(numberIndex).isEqualTo(1);
    }

    @Test
    void 특정숫자_인덱스_체크_특정숫자_없는_경우() {
        List<Integer> userInputNumber = new ArrayList<>();
        userInputNumber.add(10);
        userInputNumber.add(20);
        userInputNumber.add(30);

        int numberIndex = bullsAndCows.findNumberIndex(userInputNumber, 2);
        assertThat(numberIndex).isEqualTo(-1);
    }
}