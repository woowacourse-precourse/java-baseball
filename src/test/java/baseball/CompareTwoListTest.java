package baseball;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompareTwoListTest {

    private CompareTwoList compareTwoList;

    @BeforeEach
    public void setCompareClass() {
        compareTwoList = new CompareTwoList();
    }

    @Test
    void 두_리스트_비교() {
        List<Integer> result1 = List.of(0, 0);
        List<Integer> result2 = List.of(0, 1);
        List<Integer> result3 = List.of(0, 2);
        List<Integer> result4 = List.of(0, 3);
        List<Integer> result5 = List.of(1, 1);
        List<Integer> result6 = List.of(2, 0);
        List<Integer> result7 = List.of(3, 0);

        Assertions.assertThat(
                compareTwoList.compareLists(List.of('4', '5', '6'), List.of('1', '2', '3')))
            .isEqualTo(result1);
        Assertions.assertThat(
                compareTwoList.compareLists(List.of('4', '5', '1'), List.of('1', '2', '3')))
            .isEqualTo(result2);
        Assertions.assertThat(
                compareTwoList.compareLists(List.of('3', '1', '6'), List.of('1', '2', '3')))
            .isEqualTo(result3);
        Assertions.assertThat(
                compareTwoList.compareLists(List.of('2', '3', '1'), List.of('1', '2', '3')))
            .isEqualTo(result4);
        Assertions.assertThat(
                compareTwoList.compareLists(List.of('1', '3', '5'), List.of('1', '2', '3')))
            .isEqualTo(result5);
        Assertions.assertThat(
                compareTwoList.compareLists(List.of('1', '2', '8'), List.of('1', '2', '3')))
            .isEqualTo(result6);
        Assertions.assertThat(
                compareTwoList.compareLists(List.of('1', '2', '3'), List.of('1', '2', '3')))
            .isEqualTo(result7);
    }
}