package mytest;

import baseball.BaseballGame;
import baseball.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static baseball.BaseballGame.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DevelopmentTest {
    /**
     * 컴퓨터가 임의의 난수 3개 생성
     * 임의의 난수 3개 확인하기
     */
    @Test
    void assertRandomNumberTest(){
        RandomNumberGenerator rng = new RandomNumberGenerator();
        rng.generate();
        System.out.println(rng.randomNumberList);

        assertThat(rng.randomNumberList)
                .hasSize(3)
                .containsAnyElementsOf(List.of(1,2,3,4,5,6,7,8,9));
    }

    @Test
    void userInput_정확한_숫자를_입력하는_경우(){
        assertThat(BaseballGame.handleErrorForUserInput("352"))
                .isEqualTo(List.of(3,5,2));
    }

    @Test
    void userInput_0을_포함한_경우(){
        assertThatThrownBy(()->handleErrorForUserInput("240"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void userInput_정수가_아닌_경우(){
        assertThatThrownBy(()->handleErrorForUserInput("hello"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void userInput_세자리_정수가_아닌_경우(){
        assertThatThrownBy(()->handleErrorForUserInput("2421"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->handleErrorForUserInput("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void userInput_동일한_숫자를_포함하는_경우(){
        assertThatThrownBy(()->handleErrorForUserInput("343"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
