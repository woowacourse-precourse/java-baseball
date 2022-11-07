package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberMakerTest {
    @DisplayName("랜덤 숫자 생성 1000번 테스트")
    @Test
    void makeNumberInRangeRepeat() {
        for (int i = 0; i < 1000; i++) {
            makeNumberInRange();
        }
    }

    @DisplayName("숫자 리스트 생성 1000번 테스트")
    @Test
    void makeThreeDifferentNumberListInRangeRepeat() {
        for (int i = 0; i < 1000; i++) {
            makeThreeDifferentNumberListInRange();
        }
    }

    @DisplayName("원하는 범위의 랜덤 숫자 생성 테스트")
    @Test
    void makeNumberInRange() {
        //given
        NumberMaker numberMaker = new NumberMaker();
        int start = 1;
        int end = 9;
        //when
        int randomNumber = numberMaker.makeNumberInRange(start, end);
        //then
        assertThat(randomNumber).isBetween(start, end);
    }

    @DisplayName("원하는 범위의 서로 다른 3개의 숫자 리스트 생성 테스트")
    @Test
    void makeThreeDifferentNumberListInRange() {
        //given
        NumberMaker numberMaker = new NumberMaker();
        int start = 1;
        int end = 9;
        //when
        List<Integer> numberList = numberMaker.makeThreeDifferentNumberListInRange(start, end);
        //then
        assertThat(numberList.size()).isEqualTo(3);
        assertThat(numberList).allSatisfy(number -> assertThat(number).isBetween(start, end));
    }
}