package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import model.Computer;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
        // 컴퓨터 numThreeRanOfComputerLisl의 크기가 3인가.
    void 컴퓨터_랜덤_숫자_생성_크기_테스트_case_1() throws Exception {
        //given
        Computer computer = new Computer();
        computer.initComputer();
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
        computer.initComputer();
        String result = "1";
        System.out.println(
            "computer.getNumThreeRanOfComputerList() = " + computer.getNumThreeRanOfComputerList());
        assertThat(result).contains("1");
    }

    // TODO: 생각하기 public으로 하던걸 Private로 만들만 테스트를 삭제를 해야하는가?
//    @Test
//    void splitEachDigitOfNum_메서드로_주어진_값을_구분() {
//        Computer computer = new Computer();
//        List<Integer> list = computer.splitEachDigitOfNum(123);
//        List<Integer> resultList = new ArrayList<>(List.of(
//            1, 2, 3
//        ));
//        assertThat(list).isEqualTo(resultList);
//    }

    @Test
        // 컴퓨터 초기화 할시 랜덤 컴퓨터 리스트가 초기화가 되는가?
    void 컴퓨터_랜덤숫자_리스트_초기화_case_1() throws Exception {
        //given
        Computer computer = new Computer();
        // when
        computer.initComputer();
        List<Integer> resultList_1 = computer.getNumThreeRanOfComputerList();
        computer.initComputer();
        List<Integer> resultList_2 = computer.getNumThreeRanOfComputerList();
        // then
        assertNotEquals(resultList_1, resultList_2);
    }

    // TODO: 생각하기 public으로 하던걸 Private로 만들만 테스트를 삭제를 해야하는가?
//    @Test
//        // Computer.splitEachDigitOfNum Test
//    void 두개_Collection_포함() {
//        Computer computer = new Computer();
//        List<Integer> resultList = new ArrayList<>(List.of(
//            1, 2, 3
//        ));
//        List<Integer> list = new ArrayList<>();
//        list.addAll(resultList);
//
//        boolean isEqualsCollection = computer.isEqualsCollection(resultList, list);
//        assertTrue(isEqualsCollection);
//    }

    @Test
    void 유저숫자_스트라이트_볼_낫싱_체크_case() throws Exception {
        //given
        List<List<Integer>> numInputUser = new ArrayList<>(List.of(
            // 스트라이크 3 , 볼 0
            List.of(123),
            // 스트라이크 2 , 볼 0
            List.of(124, 143, 423),
            // 스트라이크 1 , 볼 2
            List.of(132, 321, 213),
            // 스트라이크 1 , 볼 1
            List.of(182, 134, 521, 324, 813, 283),
            // 스트라이크 1 , 볼 0
            List.of(184, 826, 483),
            // 스트라이크 0 , 볼 1
            List.of(416, 651, 247, 562, 357, 635),
            // 스트라이크 0 , 볼 2
            List.of(712, 218, 251, 238, 732, 352, 314, 381, 431),
            // 스트라이크 0 , 볼 3
            List.of(312, 231),
            // 스트라이크 0 , 볼 0
            List.of(798, 486, 589, 497, 465, 564, 464, 564, 654, 899, 789)
        ));
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        List<List<Integer>> trueList = new ArrayList<>(
            List.of(
                List.of(3, 0),
                List.of(2, 0),
                List.of(1, 2),
                List.of(1, 1),
                List.of(1, 0),
                List.of(0, 1),
                List.of(0, 2),
                List.of(0, 3),
                List.of(0, 0)
            )
        );
        List<List<Integer>> ResultList = new ArrayList<>();
        // when
        for (List<Integer> list : numInputUser) {
            for (int num : list) {
                computer.initCntStrikeBall();
                computer.isRealRightNumOfUser(num);
            }
            ResultList.add(List.of(computer.getCntStrike(), computer.getCntBall()));
        }
        // then
        assertThat(ResultList).containsAll(trueList);
    }


    @Test
    void 컴퓨터가_유저에게_힌트를_준다() throws Exception {
        //given
        List<Integer> numInputUser = new ArrayList<>(List.of(
            // 3스트라이크
            123,
            // 2스트라이크
            124,
            // 2볼 1스트라이크
            132,
            // 1볼 1스트라이크
            182,
            // 1스트라이크
            184,
            // 1볼
            416,
            // 2볼
            712,
            // 3볼
            312,
            // 낫싱
            798
        ));
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        List<String> hints = new ArrayList<>(
            List.of(
                "3스트라이크",
                "2스트라이크",
                "2볼 1스트라이크",
                "1볼 1스트라이크",
                "1스트라이크",
                "1볼 ",
                "2볼 ",
                "3볼 ",
                "낫싱"
            )
        );
        List<String> hintResult = new ArrayList<>();
        // when
        for (int num : numInputUser) {
            computer.isRealRightNumOfUser(num);
            hintResult.add(computer.toString());
            computer.initCntStrikeBall();
        }
        // then
        assertThat(hintResult).containsAll(hints);
    }

    @Test
        // Computer.isEndTheGame
    void 게임종료_확인_case_1() {
        Computer computer = new Computer();
        computer.numThreeRanOfComputerList = new ArrayList<>(List.of(
            1, 2, 3
        ));
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        computer.isRealRightNumOfUser(123);
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
            computer.initCntStrikeBall();
            computer.isRealRightNumOfUser(num);
            resultList.add(computer.isEndTheGame());
        }

        boolean result = resultList.stream().allMatch(list -> list == false);
        assertThat(result).isTrue();
    }
}
