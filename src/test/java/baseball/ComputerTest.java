package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import model.Computer;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
        // 컴퓨터 numThreeRanOfComputerLisl의 크기가 3인가.
    void 컴퓨터_랜덤_숫자_생성_크기_테스트() throws Exception {
        //given
        Computer computer = new Computer();
        computer.creatRanNumOfComputerList();
        // when
        List<Integer> resultList = computer.getNumThreeRanOfComputerList();
        // then
        System.out.println(computer.getNumThreeRanOfComputerList());

        assertThat(resultList.size()).isEqualTo(3);
    }

    // TODO: 컴퓨터도 각각의 다른 숫자가 있어야한다.
    
    // computer Test
    @Test
    void 컴퓨터가_램덤숫자_3개를_가져왔는가() {
        Computer computer = new Computer();
        List<Integer> list = new ArrayList<>();
        computer.creatRanNumOfComputerList();
        String result = "1";
        System.out.println(
            "computer.getNumThreeRanOfComputerList() = " + computer.getNumThreeRanOfComputerList());

        assertThat(result).contains("1");
    }

    @Test
    void splitEachDigitOfNum_메서드로_주어진_값을_구분() {
        Computer computer = new Computer();
        List<Integer> list = computer.splitEachDigitOfNum(123);
        List<Integer> resultList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        assertThat(list).isEqualTo(resultList);
    }

    @Test
        // Computer.splitEachDigitOfNum Test
    void 두개_Collection_포함() {
        Computer computer = new Computer();
        List<Integer> resultList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        List<Integer> list = new ArrayList<>();
        list.addAll(resultList);

        boolean isEqualsCollection = computer.isEqualsCollection(resultList, list);
        assertTrue(isEqualsCollection);
    }

    @Test
        // Computer.isRightThreeNumOfComputer
        // 스트라이크 3 , 볼 0
    void 유저숫자_스트라이트_볼_낫싱_체크_case_1() {
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 3, 5
        ));
        computer.isRightThreeNumOfComputer(135);
        int resultStrike = computer.getCntStrike();
        int resultBall = computer.getCntBall();
        ArrayList resultList = new ArrayList<>(List.of(resultStrike, resultBall));

        assertThat(resultList).isEqualTo(List.of(3, 0));
    }

    @Test
        // Computer.isRightThreeNumOfComputer
        // 스트라이크 2 , 볼 0
    void 유저숫자_스트라이트_볼_낫싱_체크_case_2() {
        int[] testInt = new int[]{124, 143, 423};
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        int resultStrike = 0;
        int resultBall = 0;
        for (int num : testInt) {
            computer.setCntBall(0);
            computer.setCntStrike(0);
            computer.isRightThreeNumOfComputer(num);
            resultStrike = computer.getCntStrike();
            resultBall = computer.getCntBall();
            ArrayList<Integer> list = new ArrayList<>(List.of(resultStrike, resultBall));
            resultList.add(list);
        }

        boolean result = resultList.stream().allMatch(list -> list.containsAll(List.of(2, 0)));
        assertThat(result).isTrue();
    }

    @Test
        // Computer.isRightThreeNumOfComputer
        // 스트라이크 1 , 볼 2
    void 유저숫자_스트라이트_볼_낫싱_체크_case_3() {
        int[] testInt = new int[]{132, 321, 213};
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        int resultStrike = 0;
        int resultBall = 0;
        for (int num : testInt) {
            computer.setCntBall(0);
            computer.setCntStrike(0);
            computer.isRightThreeNumOfComputer(num);
            resultStrike = computer.getCntStrike();
            resultBall = computer.getCntBall();
            ArrayList<Integer> list = new ArrayList<>(List.of(resultStrike, resultBall));
            resultList.add(list);
        }

        boolean result = resultList.stream().allMatch(list -> list.containsAll(List.of(1, 2)));
        assertThat(result).isTrue();
    }

    @Test
        // Computer.isRightThreeNumOfComputer
        // 스트라이크 1 , 볼 1
    void 유저숫자_스트라이트_볼_낫싱_체크_case_4() {
        int[] testInt = new int[]{182, 134, 521, 324, 813, 283};
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        int resultStrike = 0;
        int resultBall = 0;
        for (int num : testInt) {
            computer.setCntBall(0);
            computer.setCntStrike(0);
            computer.isRightThreeNumOfComputer(num);
            resultStrike = computer.getCntStrike();
            resultBall = computer.getCntBall();
            ArrayList<Integer> list = new ArrayList<>(List.of(resultStrike, resultBall));
            resultList.add(list);
        }
        boolean result = resultList.stream().allMatch(list -> list.containsAll(List.of(1, 1)));
        assertThat(result).isTrue();
    }

    @Test
        // Computer.isRightThreeNumOfComputer
        // 스트라이크 1 , 볼 0
    void 유저숫자_스트라이트_볼_낫싱_체크_case_8() {
        int[] testInt = new int[]{184, 826, 483};
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        int resultStrike = 0;
        int resultBall = 0;
        for (int num : testInt) {
            computer.setCntBall(0);
            computer.setCntStrike(0);
            computer.isRightThreeNumOfComputer(num);
            resultStrike = computer.getCntStrike();
            resultBall = computer.getCntBall();
            ArrayList<Integer> list = new ArrayList<>(List.of(resultStrike, resultBall));
            resultList.add(list);
        }

        boolean result = resultList.stream().allMatch(list -> list.containsAll(List.of(1, 0)));
        assertThat(result).isTrue();
    }

    @Test
        // Computer.isRightThreeNumOfComputer
        // 스트라이크 0 , 볼 1
    void 유저숫자_스트라이트_볼_낫싱_체크_case_5() {
        int[] testInt = new int[]{416, 651, 247, 562, 357, 635};
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        int resultStrike = 0;
        int resultBall = 0;
        for (int num : testInt) {
            computer.setCntBall(0);
            computer.setCntStrike(0);
            computer.isRightThreeNumOfComputer(num);
            resultStrike = computer.getCntStrike();
            resultBall = computer.getCntBall();
            ArrayList<Integer> list = new ArrayList<>(List.of(resultStrike, resultBall));
            resultList.add(list);
        }

        boolean result = resultList.stream().allMatch(list -> list.containsAll(List.of(0, 1)));
        assertThat(result).isTrue();
    }

    @Test
        // Computer.isRightThreeNumOfComputer
        // 스트라이크 0 , 볼 2
    void 유저숫자_스트라이트_볼_낫싱_체크_case_6() {
        int[] testInt = new int[]{712, 218, 251, 238, 732, 352, 314, 381, 431};
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        int resultStrike = 0;
        int resultBall = 0;
        for (int num : testInt) {
            computer.setCntBall(0);
            computer.setCntStrike(0);
            computer.isRightThreeNumOfComputer(num);
            resultStrike = computer.getCntStrike();
            resultBall = computer.getCntBall();
            ArrayList<Integer> list = new ArrayList<>(List.of(resultStrike, resultBall));
            resultList.add(list);
        }

        boolean result = resultList.stream().allMatch(list -> list.containsAll(List.of(0, 2)));
        assertThat(result).isTrue();
    }

    @Test
        // Computer.isRightThreeNumOfComputer
        // 스트라이크 0 , 볼 3
    void 유저숫자_스트라이트_볼_낫싱_체크_case_7() {
        int[] testInt = new int[]{312, 231};
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        int resultStrike = 0;
        int resultBall = 0;
        for (int num : testInt) {
            computer.setCntBall(0);
            computer.setCntStrike(0);
            computer.isRightThreeNumOfComputer(num);
            resultStrike = computer.getCntStrike();
            resultBall = computer.getCntBall();
            ArrayList<Integer> list = new ArrayList<>(List.of(resultStrike, resultBall));
            resultList.add(list);
        }
        boolean result = resultList.stream().allMatch(list -> list.containsAll(List.of(0, 3)));
        assertThat(result).isTrue();
    }

    @Test
        // Computer.isRightThreeNumOfComputer
        // 스트라이크 0 , 볼 0
    void 유저숫자_스트라이트_볼_낫싱_체크_case_9() {
        int[] testInt = new int[]{798, 486, 589, 497, 465, 564, 464, 564, 654, 899, 789};
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        int resultStrike = 0;
        int resultBall = 0;
        for (int num : testInt) {
            computer.setCntBall(0);
            computer.setCntStrike(0);
            computer.isRightThreeNumOfComputer(num);
            resultStrike = computer.getCntStrike();
            resultBall = computer.getCntBall();
            ArrayList<Integer> list = new ArrayList<>(List.of(resultStrike, resultBall));
            resultList.add(list);
        }
        boolean result = resultList.stream().allMatch(list -> list.containsAll(List.of(0, 0)));
        assertThat(result).isTrue();
    }


    @Test
        // Computer.isEndTheGame
    void 게임종료_확인_case_1() {
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        computer.isRightThreeNumOfComputer(123);
        boolean result = computer.isEndTheGame();
        assertThat(result).isTrue();
    }

    @Test
    void 게임종료_확인_case_2() {
        int[] testInt = new int[]{124, 143, 423, 132, 321, 213, 182, 134, 521, 324, 813, 283, 184,
            826, 483, 416, 651, 247, 562, 357, 635, 712, 218, 251, 238, 732, 352, 314, 381, 431,
            312, 231, 798, 486, 589, 497, 465, 564, 464, 564, 654, 899, 789};
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        ArrayList<Boolean> resultList = new ArrayList<>();
        for (int num : testInt) {
            computer.setCntBall(0);
            computer.setCntStrike(0);
            computer.isRightThreeNumOfComputer(num);
            resultList.add(computer.isEndTheGame());
        }

        boolean result = resultList.stream().allMatch(list -> list == false);
        assertThat(result).isTrue();
    }
}
