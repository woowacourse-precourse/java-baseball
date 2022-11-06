package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberComparatorTest {

    @Test
    void 위치와_숫자_모두_같은경우_3스트라이크_반환() {
        // given
        List<Integer> inputNumberList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> resultNumberList = new ArrayList<>(Arrays.asList(1, 2, 3));
        NumberComparator numberComparator = new NumberComparator(inputNumberList, resultNumberList);
        // when
        numberComparator.compare();
        String compareResult = numberComparator.getCompareResult();
        // then
        assertThat(compareResult).isEqualTo("3스트라이크");
    }

    @Test
    void 같은_위치숫자_2개_다른위치_같은숫자_0개인경우_2스트라이크_반환() {
        // given
        List<Integer> inputNumberList = new ArrayList<>(Arrays.asList(1, 2, 5));
        List<Integer> resultNumberList = new ArrayList<>(Arrays.asList(1, 2, 3));
        NumberComparator numberComparator = new NumberComparator(inputNumberList, resultNumberList);
        // when
        numberComparator.compare();
        String compareResult = numberComparator.getCompareResult();
        // then
        assertThat(compareResult).isEqualTo("2스트라이크");
    }

    @Test
    void 같은_위치숫자_1개인경우_1스트라이크_반환() {
        // given
        List<Integer> inputNumberList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> resultNumberList = new ArrayList<>(Arrays.asList(1, 4, 5));
        NumberComparator numberComparator = new NumberComparator(inputNumberList, resultNumberList);
        // when
        numberComparator.compare();
        String compareResult = numberComparator.getCompareResult();
        // then
        assertThat(compareResult).isEqualTo("1스트라이크");
    }

    @Test
    void 위치만_모두_같은경우_3볼_반환() {
        // given
        List<Integer> inputNumberList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> resultNumberList = new ArrayList<>(Arrays.asList(3, 1, 2));
        NumberComparator numberComparator = new NumberComparator(inputNumberList, resultNumberList);
        // when
        numberComparator.compare();
        String compareResult = numberComparator.getCompareResult();
        // then
        assertThat(compareResult).isEqualTo("3볼");
    }

    @Test
    void 같은_위치숫자_1개_다른위치_같은숫자_1개인경우_1볼1스트라이크_반환() {
        // given
        List<Integer> inputNumberList = new ArrayList<>(Arrays.asList(1, 2, 5));
        List<Integer> resultNumberList = new ArrayList<>(Arrays.asList(1, 3, 2));
        NumberComparator numberComparator = new NumberComparator(inputNumberList, resultNumberList);
        // when
        numberComparator.compare();
        String compareResult = numberComparator.getCompareResult();
        // then
        assertThat(compareResult).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 같은_위치숫자_1개_다른위치_같은숫자_2개인경우_2볼1스트라이크_반환() {
        // given
        List<Integer> inputNumberList = new ArrayList<>(Arrays.asList(1, 2, 5));
        List<Integer> resultNumberList = new ArrayList<>(Arrays.asList(1, 5, 2));
        NumberComparator numberComparator = new NumberComparator(inputNumberList, resultNumberList);
        // when
        numberComparator.compare();
        String compareResult = numberComparator.getCompareResult();
        // then
        assertThat(compareResult).isEqualTo("2볼 1스트라이크");
    }


    @Test
    void 위치_숫자_전부_다른경우_낫싱_반환() {
        // given
        List<Integer> inputNumberList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> resultNumberList = new ArrayList<>(Arrays.asList(4, 5, 6));
        NumberComparator numberComparator = new NumberComparator(inputNumberList, resultNumberList);
        // when
        numberComparator.compare();
        String compareResult = numberComparator.getCompareResult();
        // then
        assertThat(compareResult).isEqualTo("낫싱");
    }

}