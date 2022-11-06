package baseball.model;

import static org.assertj.core.api.Assertions.*;
import baseball.controller.Valid;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void generateRandomNum_numList정확도테스트_10000번테스트() {
        //given
        Computer[] computer = new Computer[10000];
        //when
        int notValidTestCase = 0;
        for (int i = 0; i < 10000; i++) {
            computer[i] = new Computer();
            List<Integer> generateRandomNumList = computer[i].generateRandomNumList();
            if (!Valid.isValidNumList(generateRandomNumList)) {
                notValidTestCase++;
            }
        }
        //then
        assertThat(notValidTestCase).isEqualTo(0);
    }


    @Test
    void compareUsersNum_1스트라이크() {
        //given
        Computer computer = new Computer();
        computer.generateRandomNumList();
        List<Integer> randomNum = computer.getRandomNum();
        int firstNum = randomNum.get(0);
        //when
        List<Integer> oneStrike = Arrays.asList(firstNum, 0, 0);
        Computer resultComputer = computer.compareUsersNum(oneStrike);
        //then
        assertThat(resultComputer.getStrike()).isEqualTo(1);
        assertThat(resultComputer.getBall()).isEqualTo(0);
        assertThat(resultComputer.getNothing()).isEqualTo(false);
    }

    @Test
    void compareUsersNum_2스트라이크() {
        //given
        Computer computer = new Computer();
        computer.generateRandomNumList();
        List<Integer> randomNum = computer.getRandomNum();
        int firstNum = randomNum.get(0);
        int secondNum = randomNum.get(1);
        //when
        List<Integer> twoStrike = Arrays.asList(firstNum, secondNum, 0);
        Computer resultComputer = computer.compareUsersNum(twoStrike);
        //then
        assertThat(resultComputer.getStrike()).isEqualTo(2);
        assertThat(resultComputer.getBall()).isEqualTo(0);
        assertThat(resultComputer.getNothing()).isEqualTo(false);
    }

    @Test
    void compareUsersNum_1볼() {
        //given
        Computer computer = new Computer();
        computer.generateRandomNumList();
        List<Integer> randomNum = computer.getRandomNum();
        int firstNum = randomNum.get(0);
        //when
        List<Integer> oneBall = Arrays.asList(0, firstNum, 0);
        Computer resultComputer = computer.compareUsersNum(oneBall);
        //then
        assertThat(resultComputer.getStrike()).isEqualTo(0);
        assertThat(resultComputer.getBall()).isEqualTo(1);
        assertThat(resultComputer.getNothing()).isEqualTo(false);
    }

    @Test
    void compareUsersNum_2볼() {
        //given
        Computer computer = new Computer();
        computer.generateRandomNumList();
        List<Integer> randomNum = computer.getRandomNum();
        int firstNum = randomNum.get(0);
        int secondNum = randomNum.get(1);
        //when
        List<Integer> twoBall = Arrays.asList(secondNum, firstNum, 0);
        Computer resultComputer = computer.compareUsersNum(twoBall);
        //then
        assertThat(resultComputer.getStrike()).isEqualTo(0);
        assertThat(resultComputer.getBall()).isEqualTo(2);
        assertThat(resultComputer.getNothing()).isEqualTo(false);
    }

    @Test
    void compareUsersNum_3볼() {
        //given
        Computer computer = new Computer();
        computer.generateRandomNumList();
        List<Integer> randomNum = computer.getRandomNum();
        int firstNum = randomNum.get(0);
        int secondNum = randomNum.get(1);
        int thirdNum = randomNum.get(2);
        //when
        List<Integer> thirdBall = Arrays.asList(secondNum, thirdNum, firstNum);
        Computer resultComputer = computer.compareUsersNum(thirdBall);
        //then
        assertThat(resultComputer.getStrike()).isEqualTo(0);
        assertThat(resultComputer.getBall()).isEqualTo(3);
        assertThat(resultComputer.getNothing()).isEqualTo(false);
    }

    @Test
    void compareUsersNum_1스트라이크1볼() {
        //given
        Computer computer = new Computer();
        computer.generateRandomNumList();
        List<Integer> randomNum = computer.getRandomNum();
        int firstNum = randomNum.get(0);
        int secondNum = randomNum.get(1);
        //when
        List<Integer> oneStrikeOneBall = Arrays.asList(firstNum, 0, secondNum);
        Computer resultComputer = computer.compareUsersNum(oneStrikeOneBall);
        //then
        assertThat(resultComputer.getStrike()).isEqualTo(1);
        assertThat(resultComputer.getBall()).isEqualTo(1);
        assertThat(resultComputer.getNothing()).isEqualTo(false);
    }

    @Test
    void compareUsersNum_1스트라이크2볼() {
        //given
        Computer computer = new Computer();
        computer.generateRandomNumList();
        List<Integer> randomNum = computer.getRandomNum();
        int firstNum = randomNum.get(0);
        int secondNum = randomNum.get(1);
        int thirdNum = randomNum.get(2);
        //when
        List<Integer> oneStrikeTwoBall = Arrays.asList(firstNum, thirdNum, secondNum);
        Computer resultComputer = computer.compareUsersNum(oneStrikeTwoBall);
        //then
        assertThat(resultComputer.getStrike()).isEqualTo(1);
        assertThat(resultComputer.getBall()).isEqualTo(2);
        assertThat(resultComputer.getNothing()).isEqualTo(false);
    }

}