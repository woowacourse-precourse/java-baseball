package baseball.opponent;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomsTest {

    @Nested
    @DisplayName("pickNumberInList 테스트")
    class PickNumberInList {

        @Test
        @DisplayName("정상 리스트 테스트")
        void validListTest() {
            //given
            List<Integer> integers = List.of(1, 2, 3, 4);

            //when
            int res = Randoms.pickNumberInList(integers);

            //then
            assertThat(integers.contains(res)).isTrue();
        }

        @Test
        @DisplayName("빈 리스트 테스트")
        void emptyListTest() {
            //given
            List<Integer> integers = List.of();

            //when then
            assertThatThrownBy(() -> Randoms.pickNumberInList(integers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("numbers cannot be empty.");
        }

        @Test
        @DisplayName("null 테스트")
        void nullTest() {
            //given
            List<Integer> integers = null;

            //when then
            assertThatThrownBy(() -> Randoms.pickNumberInList(integers))
                    .isInstanceOf(NullPointerException.class);
        }
    }

    @Nested
    @DisplayName("pickNumberInRange 테스트")
    class PickNumberInRangeTest {

        @Test
        @DisplayName("startInclusive < endInclusive 3 ~ 4 사이 숫자")
        void startInclusiveLargeThanEndInclusive_case1() {
            //given
            int startInclusive = 3;
            int endInclusive = 4;

            //when
            int res = Randoms.pickNumberInRange(startInclusive, endInclusive);

            //then
            assertThat(res).isGreaterThanOrEqualTo(startInclusive);
            assertThat(res).isLessThanOrEqualTo(endInclusive);
        }

        @Test
        @DisplayName("startInclusive < endInclusive 3 ~ 9 사이 숫자")
        void startInclusiveLargeThanEndInclusive_case2() {
            //given
            int startInclusive = 3;
            int endInclusive = 9;

            //when
            int res = Randoms.pickNumberInRange(startInclusive, endInclusive);

            //then
            assertThat(res).isGreaterThanOrEqualTo(startInclusive);
            assertThat(res).isLessThanOrEqualTo(endInclusive);
        }

        @Test
        @DisplayName("startInclusive = endInclusive 4")
        void startInclusiveEqualToEndInclusive() {
            //given
            int startInclusive = 4;
            int endInclusive = 4;

            //when
            int res = Randoms.pickNumberInRange(startInclusive, endInclusive);

            //then
            assertThat(res).isEqualTo(4);
        }

        @Test
        @DisplayName("startInclusive > endInclusive 예외")
        void startInclusiveLessThanEndInclusive() {
            //given
            int startInclusive = 4;
            int endInclusive = 3;

            //when then
            assertThatThrownBy(() -> Randoms.pickNumberInRange(startInclusive, endInclusive))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("startInclusive cannot be greater than endInclusive.");
        }

        @Test
        @DisplayName("endInclusive가 int 최대값일 때 예외")
        void endInclusiveEqualToIntegerMaxValue() {
            //given
            int startInclusive = 0;
            int endInclusive = Integer.MAX_VALUE;

            //when then
            assertThatThrownBy(() -> Randoms.pickNumberInRange(startInclusive, endInclusive))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("endInclusive cannot be greater than Integer.MAX_VALUE.");
        }

        @Test
        @DisplayName("범위가 int 범위 넘어갈 때 예외")
        void rangeLargeOrEqualToIntegerMaxValue() {
            //given
            int startInclusive = -1;
            int endInclusive = Integer.MAX_VALUE - 1;

            //when then
            assertThatThrownBy(() -> Randoms.pickNumberInRange(startInclusive, endInclusive))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("the input range is too large.");
        }
    }

    @Nested
    @DisplayName("pickUniqueNumbersInRange 테스트")
    class PickUniqueNumbersInRangeTest {

        @Test
        @DisplayName("startInclusive: 3 endInclusive: 9 count: 3")
        void successTest_case1() {
            //given
            int startInclusive = 3;
            int endInclusive = 9;
            int count = 3;

            //when
            List<Integer> res = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);

            //then
            assertThat(res.size()).isEqualTo(count);
            assertThat(new HashSet<>(res).size()).isEqualTo(count);
            for (Integer pickedNumber : res) {
                assertThat(pickedNumber).isGreaterThanOrEqualTo(startInclusive);
                assertThat(pickedNumber).isLessThanOrEqualTo(endInclusive);
            }
        }

        @Test
        @DisplayName("startInclusive: -5 endInclusive: 9 count: 5")
        void successTest_case2() {
            //given
            int startInclusive = -5;
            int endInclusive = 9;
            int count = 5;

            //when
            List<Integer> res = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);

            //then
            assertThat(res.size()).isEqualTo(count);
            assertThat(new HashSet<>(res).size()).isEqualTo(count);
            for (Integer pickedNumber : res) {
                assertThat(pickedNumber).isGreaterThanOrEqualTo(startInclusive);
                assertThat(pickedNumber).isLessThanOrEqualTo(endInclusive);
            }
        }

        @Test
        @DisplayName("startInclusive: 3 endInclusive: 3 count: 1")
        void successTest_case3() {
            //given
            int startInclusive = 3;
            int endInclusive = 3;
            int count = 1;

            //when
            List<Integer> res = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);

            //then
            assertThat(res.size()).isEqualTo(count);
            assertThat(new HashSet<>(res).size()).isEqualTo(count);
            assertThat(res.get(0)).isEqualTo(startInclusive);
        }

        @Test
        @DisplayName("startInclusive: 3 endInclusive: 3 count: 0")
        void successTest_case4() {
            //given
            int startInclusive = 3;
            int endInclusive = 3;
            int count = 0;

            //when
            List<Integer> res = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);

            //then
            assertThat(res.size()).isEqualTo(count);
        }

        @Test
        @DisplayName("startInclusive > endInclusive 예외")
        void startInclusiveLessThanEndInclusive() {
            //given
            int startInclusive = 4;
            int endInclusive = 3;
            int count = 1;

            //when then
            assertThatThrownBy(() -> Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("startInclusive cannot be greater than endInclusive.");
        }

        @Test
        @DisplayName("endInclusive가 int 최대값일 때 예외")
        void endInclusiveEqualToIntegerMaxValue() {
            //given
            int startInclusive = 0;
            int endInclusive = Integer.MAX_VALUE;
            int count = 1;

            //when then
            assertThatThrownBy(() -> Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("endInclusive cannot be greater than Integer.MAX_VALUE.");
        }

        @Test
        @DisplayName("count가 0보다 작을 때 예외")
        void countLessThanZero() {
            //given
            int startInclusive = 3;
            int endInclusive = 9;
            int count = -1;

            //when then
            assertThatThrownBy(() -> Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("count cannot be less than zero.");
        }

        @Test
        @DisplayName("count가 범위보다 클 경우 예외")
        void countOutOfRange() {
            //given
            int startInclusive = 3;
            int endInclusive = 9;
            int count = Integer.MAX_VALUE;

            //when then
            assertThatThrownBy(() -> Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("count cannot be greater than the input range.");
        }
    }
}
