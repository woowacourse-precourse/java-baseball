package baseball.view;

import static org.assertj.core.api.Assertions.*;
import baseball.model.Computer;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class PrintConsoleTest {

    @Test
    void printResult_스트라이크() {
        //given
        Computer computer = new Computer();
        computer.generateRandomNumList();
        List<Integer> randomNum = computer.getRandomNum();
        int firstNum = randomNum.get(0);
        List<Integer> oneStrike = Arrays.asList(firstNum, 0, 0);
        Computer resultComputer = computer.compareUsersNum(oneStrike);
        //when
        String result = PrintConsole.printResult(resultComputer);
        //then
        assertThat(result).isEqualTo("1스트라이크"+'\n');
    }

    @Test
    void printResult_볼() {
        //given
        Computer computer = new Computer();
        computer.generateRandomNumList();
        List<Integer> randomNum = computer.getRandomNum();
        int firstNum = randomNum.get(0);
        List<Integer> oneBall = Arrays.asList(0, firstNum, 0);
        Computer resultComputer = computer.compareUsersNum(oneBall);
        //when
        String result = PrintConsole.printResult(resultComputer);
        //then
        assertThat(result).isEqualTo("1볼"+'\n');
    }

    @Test
    void printResult_볼앤스트라이크() {
        //given
        Computer computer = new Computer();
        computer.generateRandomNumList();
        List<Integer> randomNum = computer.getRandomNum();
        int firstNum = randomNum.get(0);
        int secondNum = randomNum.get(1);
        List<Integer> oneBallOneStrike = Arrays.asList(firstNum, 0, secondNum);
        Computer resultComputer = computer.compareUsersNum(oneBallOneStrike);
        //when
        String result = PrintConsole.printResult(resultComputer);
        //then
        assertThat(result).isEqualTo("1볼 1스트라이크"+'\n');
    }

    @Test
    void printResult_3스트라이크() {
        //given
        Computer computer = new Computer();
        computer.generateRandomNumList();
        List<Integer> randomNum = computer.getRandomNum();
        int firstNum = randomNum.get(0);
        int secondNum = randomNum.get(1);
        int thirdNum = randomNum.get(2);
        List<Integer> threeStrike = Arrays.asList(firstNum, secondNum, thirdNum);
        Computer resultComputer = computer.compareUsersNum(threeStrike);
        //when
        String result = PrintConsole.printResult(resultComputer);
        //then
        assertThat(result).isEqualTo("3스트라이크"+'\n');
    }

    @Test
    void printResult_낫싱() {
        //given
        Computer computer = new Computer();
        computer.generateRandomNumList();
        List<Integer> nothing = Arrays.asList(0, 0, 0);
        Computer resultComputer = computer.compareUsersNum(nothing);
        //when
        String result = PrintConsole.printResult(resultComputer);
        //then
        assertThat(result).isEqualTo("낫싱"+'\n');
    }
}