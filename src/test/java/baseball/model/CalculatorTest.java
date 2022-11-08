package baseball.model;

import baseball.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class CalculatorTest {

    @Test
    @DisplayName("3스트라이크인 경우")
    void case1(){
        //given
        List<Integer> randomNumbers = List.of(1,2,3);
        List<Integer> userNumbers = List.of(1,2,3);
        Calculator calculator = new Calculator(randomNumbers,userNumbers);
        //when
        String result = calculator.calculate();
        //then
        Assertions.assertThat(result).isEqualTo("3스트라이크\n");
    }

    @Test
    @DisplayName("낫싱 경우")
    void case2(){
        //given
        List<Integer> randomNumbers = List.of(1,2,3);
        List<Integer> userNumbers = List.of(4,5,6);
        Calculator calculator = new Calculator(randomNumbers,userNumbers);
        //when
        String result = calculator.calculate();
        //then
        Assertions.assertThat(result).isEqualTo("낫싱\n");
    }

    @Test
    @DisplayName("볼만 있는 경우")
    void case3(){
        //given
        List<Integer> randomNumbers = List.of(1,2,3);
        List<Integer> userNumbers = List.of(3,4,1);
        Calculator calculator = new Calculator(randomNumbers,userNumbers);
        //when
        String result = calculator.calculate();
        //then
        Assertions.assertThat(result).isEqualTo("2볼\n");
    }

    @Test
    @DisplayName("스트라이크만 있는 경우")
    void case4(){
        //given
        List<Integer> randomNumbers = List.of(1,2,3);
        List<Integer> userNumbers = List.of(1,2,4);
        Calculator calculator = new Calculator(randomNumbers,userNumbers);
        //when
        String result = calculator.calculate();
        //then
        Assertions.assertThat(result).isEqualTo("2스트라이크\n");
    }

    @Test
    @DisplayName("볼,스트라이크가 모두 있는 경우 ")
    void case5(){
        //given
        List<Integer> randomNumbers = List.of(1,2,3);
        List<Integer> userNumbers = List.of(3,2,1);
        Calculator calculator = new Calculator(randomNumbers,userNumbers);
        //when
        String result = calculator.calculate();
        //then
        Assertions.assertThat(result).isEqualTo("2볼 1스트라이크\n");
    }
}
