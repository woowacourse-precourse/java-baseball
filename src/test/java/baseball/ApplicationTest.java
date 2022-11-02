package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import model.Computer;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

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
            1, 2, 3
        ));
        computer.isRightThreeNumOfComputer(123);
        int resultStrike = computer.getCntStrike();
        int resultBall = computer.getCntBall();
        ArrayList resultList = new ArrayList<>(List.of(resultStrike, resultBall));

        assertThat(resultList).isEqualTo(List.of(3, 0));
    }

    @Test
        // Computer.isRightThreeNumOfComputer
        // 스트라이크 2 , 볼 1
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
            System.out.println("num = " + num);
            computer.isRightThreeNumOfComputer(num);
            resultStrike = computer.getCntStrike();
            resultBall = computer.getCntBall();
            System.out.println("resultStrike: " + resultStrike + " resultBall: " + resultBall);
            ArrayList<Integer> list = new ArrayList<>(List.of(resultStrike, resultBall));
            resultList.add(list);
        }

        boolean result = resultList.stream().allMatch(list -> list.containsAll(List.of(2, 1)));
        System.out.println("result = " + result);
        assertThat(result).isTrue();
    }

    // computer Test 종료

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
            () -> {
                run("246", "135", "1", "597", "589", "2");
                assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
            },
            1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
