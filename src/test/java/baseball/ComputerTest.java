package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    Computer computer = new Computer();
    @Test
    void 컴퓨터_숫자_3자리인지_테스트() {
        //given
        List<Integer> numberList = computer.getRandomNumber();
        //then
        assertThat(numberList.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_숫자_중복없는지_테스트() {
        //given
        List<Integer> numberList = computer.getRandomNumber();
        //when
        Set<Integer> numberSet = new HashSet<>(numberList);
        //then
        assertThat(numberSet.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_첫번째_자리수를_올바르게_가져오는지_테스트() {
        //given
        List<Integer> numberList = computer.getRandomNumber();
        //when
        int firstNumber = computer.getFirstRandomNumber();
        //then
        assertThat(firstNumber).isEqualTo(numberList.get(0));
    }

    @Test
    void 컴퓨터_두번째_자리수를_올바르게_가져오는지_테스트() {
        //given
        List<Integer> numberList = computer.getRandomNumber();
        //when
        int secondNumber = computer.getSecondRandomNumber();
        //then
        assertThat(secondNumber).isEqualTo(numberList.get(1));
    }

    @Test
    void 컴퓨터_세번째_자리수를_올바르게_가져오는지_테스트() {
        //given
        List<Integer> numberList = computer.getRandomNumber();
        //when
        int thirdNumber = computer.getThirdRandomNumber();
        //then
        assertThat(thirdNumber).isEqualTo(numberList.get(2));
    }

}
