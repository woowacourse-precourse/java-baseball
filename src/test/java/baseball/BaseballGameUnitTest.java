package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class BaseBallGameUnitTest {

    @Test
    public void getPlaceValuesTest() {

        // given
        int [] testCases = {285, 153, 895, 706, 140, 6891, 23};

        // when
        List<Integer> result0 = Application.getPlaceValuesFromNum(testCases[0]);
        List<Integer> result1 = Application.getPlaceValuesFromNum(testCases[1]);
        List<Integer> result2 = Application.getPlaceValuesFromNum(testCases[2]);


        // then
        assertThat(result0.get(0)).isEqualTo(5);
        assertThat(result0.get(1)).isEqualTo(8);
        assertThat(result0.get(2)).isEqualTo(2);
        assertThat(result1.get(0)).isEqualTo(3);
        assertThat(result1.get(1)).isEqualTo(5);
        assertThat(result1.get(2)).isEqualTo(1);
        assertThat(result2.get(0)).isEqualTo(5);
        assertThat(result2.get(1)).isEqualTo(9);
        assertThat(result2.get(2)).isEqualTo(8);


        assertThrows(IllegalArgumentException.class,
                () -> {Application.getPlaceValuesFromNum(testCases[3]);});
        assertThrows(IllegalArgumentException.class,
                () -> {Application.getPlaceValuesFromNum(testCases[4]);});
        assertThrows(IllegalArgumentException.class,
                () -> {Application.getPlaceValuesFromNum(testCases[5]);});
        assertThrows(IllegalArgumentException.class,
                () -> {Application.getPlaceValuesFromNum(testCases[6]);});

    }

    @Test
    public void getResultFromCurrentInputTest() {
        // given
        int [] testUsers = new int[9];
        testUsers[0] = 279; // 낫싱
        testUsers[1] = 486; // 3볼
        testUsers[2] = 683; // 2볼
        testUsers[3] = 431; // 1볼
        testUsers[4] = 684; // 2볼 1스트라이크
        testUsers[5] = 842; // 1볼 1스트라이크
        testUsers[6] = 367; // 1스트라이크
        testUsers[7] = 874; // 2스트라이크
        testUsers[8] = 864; // 3스트라이크

        // when
        List<Integer> computer = new ArrayList<>();
        computer.add(4);
        computer.add(6);
        computer.add(8);
        computer.add(864);

        // then
        for(int user : testUsers) {
            Application.ballStrikeCountFromCurrentInput(computer, user);
        }

    }

    @Test
    public void getRandomIntTest() {
        List<Integer> testList = Application.getComputersValue();
        for(int value: testList) {
            System.out.println(value);
        }

        System.out.println("========================================");

        List<Integer> testList2 = Application.getComputersValue();
        for(int value : testList2) {
            System.out.println(value);
        }

        System.out.println("========================================");

        List<Integer> testList3 = Application.getComputersValue();
        for(int value : testList3) {
            System.out.println(value);
        }

        System.out.println("========================================");

        List<Integer> testList4 = Application.getComputersValue();
        for(int value : testList4) {
            System.out.println(value);
        }

        System.out.println("========================================");

        List<Integer> testList5 = Application.getComputersValue();
        for(int value : testList5) {
            System.out.println(value);
        }
    }

}
