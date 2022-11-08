package mytest;

import baseball.BaseballGame;
import baseball.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.BaseballGame.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DevelopmentTest {
    /**
     * 컴퓨터가 임의의 난수 3개 생성,
     * 임의의 난수 3개 확인하기
     */
    @Test
    @DisplayName("컴퓨터에서 생성한 정수 난수 배열의 크기와 범위 검증 테스트")
    void assertRandomNumberTest(){
        RandomNumberGenerator rng = new RandomNumberGenerator();
        rng.generate();
        System.out.println(rng.randomNumberList);

        assertThat(rng.randomNumberList)
                .hasSize(3)
                .containsAnyElementsOf(List.of(1,2,3,4,5,6,7,8,9));
    }

    /**
     * 사용자의 입력값 에러 처리
     */
    @Test
    @DisplayName("사용자가 정수 3자리 수를 올바르게 입력하는 경우 검증 테스트")
    void appropriateUserInputTest(){
        assertThat(BaseballGame.handleErrorForUserInput("352"))
                .isEqualTo(List.of(3,5,2));
    }

    @Test
    @DisplayName("사용자 입력 값이 0을 포함하는 경우 오류 처리 검증 테스트")
    void userInputContainsZeroTest(){
        assertThatThrownBy(()->handleErrorForUserInput("240"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자 입력 값이 정수가 아닌 경우 오류 처리 검증 테스트")
    void userInputNotIntegerTest(){
        assertThatThrownBy(()->handleErrorForUserInput("hello"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자 입력 값이 세자리 정수가 아닌 경우 오류 처리 검증 테스트")
    void userInputNotThreeIntegerDigit(){
        assertThatThrownBy(()->handleErrorForUserInput("2421"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->handleErrorForUserInput("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자 입력 값이 서로 다른 세 정수가 아닌 경우 오류 처리 검증 테스트")
    void userInputNotThreeDistinctiveInteger(){
        assertThatThrownBy(()->handleErrorForUserInput("343"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
