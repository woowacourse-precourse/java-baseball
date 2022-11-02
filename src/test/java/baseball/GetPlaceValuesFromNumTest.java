package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class GetPlaceValuesFromNumTest {

    @Test
    public void getPlaceValuesTest() {

        // given
        int [] testCases = {285, 153, 895, 706, 140, 6891, 23};

        // when
        List<Integer> result0 = Application.getPlaceValuesFromNum(testCases[0]);
        List<Integer> result1 = Application.getPlaceValuesFromNum(testCases[1]);
        List<Integer> result2 = Application.getPlaceValuesFromNum(testCases[2]);


        // then
        Assertions.assertThat(result0.get(0)).isEqualTo(5);
        Assertions.assertThat(result0.get(1)).isEqualTo(8);
        Assertions.assertThat(result0.get(2)).isEqualTo(2);
        Assertions.assertThat(result1.get(0)).isEqualTo(3);
        Assertions.assertThat(result1.get(1)).isEqualTo(5);
        Assertions.assertThat(result1.get(2)).isEqualTo(1);
        Assertions.assertThat(result2.get(0)).isEqualTo(5);
        Assertions.assertThat(result2.get(1)).isEqualTo(9);
        Assertions.assertThat(result2.get(2)).isEqualTo(8);


        assertThrows(IllegalArgumentException.class,
                () -> {Application.getPlaceValuesFromNum(testCases[3]);});
        assertThrows(IllegalArgumentException.class,
                () -> {Application.getPlaceValuesFromNum(testCases[4]);});
        assertThrows(IllegalArgumentException.class,
                () -> {Application.getPlaceValuesFromNum(testCases[5]);});
        assertThrows(IllegalArgumentException.class,
                () -> {Application.getPlaceValuesFromNum(testCases[6]);});

    }



}
