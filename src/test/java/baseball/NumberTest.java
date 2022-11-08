package baseball;

import domain.ComputerNumberList;
import domain.Number;
import domain.UserInputNumberList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    private static final int NUMBER_SIZE = 3;

    ComputerNumberList computerNumberList;
    UserInputNumberList userInputNumberList;

    @BeforeEach
    void createList() {
        computerNumberList = new ComputerNumberList();
        userInputNumberList = new UserInputNumberList();
    }

    /**
     * 컴퓨터 랜덤숫자 검증
     */
    @Test
    void 컴퓨터_숫자가_3자리인지_검증() {
        //given
        computerNumberList.generateNewRandomNumber();
        List<Number> computerNumber = computerNumberList.getComputerNumber();
        //when
        int computerNumberSize = computerNumber.size();
        //then
        assertThat(computerNumberSize).isEqualTo(NUMBER_SIZE);
    }

    @Test
    void 컴퓨터의_숫자중_중복이_있는지_검증() {
        //given
        computerNumberList.generateNewRandomNumber();
        List<Number> computerNumber = computerNumberList.getComputerNumber();
        int computerNumberSize = computerNumber.size();
        //when
        List<Number> distinctComputerList = computerNumber.stream().distinct().collect(Collectors.toList());
        int distinctComputerListSize = distinctComputerList.size();
        //then
        assertThat(distinctComputerListSize).isEqualTo(computerNumberSize);
    }

    /**
     * 사용자 입력 검증
     */
    @Test
    void 사용자가_정상적으로_값을_입력했을떄_정상적으로_주입() {
        //given
        String userInput;
        //when
        userInput = "123";
        userInputNumberList.setUserInputNumberList(userInput);
        List<Number> inputList = Arrays.stream(userInput.split(""))
                .map(Number::new)
                .collect(Collectors.toList());
        //then
        assertThat(userInputNumberList.getUserInputNumberList()).isEqualTo(inputList);
    }

    @Test
    void 사용자가_적절하지_않은_길이의_값을_입력했을떄_예외발생() {
        //given
        String userInput;
        //when
        userInput = "1234";
        //then
        assertThatThrownBy(() -> userInputNumberList.setUserInputNumberList(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 숫자를 입력해야 합니다.");
    }

    @Test
    void 사용자_중복된_숫자를_입력했을때_예외발생() {
        //given
        String userInput;
        //when
        userInput = "133";
        //then
        assertThatThrownBy(() -> userInputNumberList.setUserInputNumberList(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 입력되었습니다.");
    }

    @Test
    void 사용자가_유효범위를_벗어난_수를_입력하였을떄_예외발생() {
        //given
        String userInput;
        //when
        userInput = "023";
        //then
        assertThatThrownBy(() -> userInputNumberList.setUserInputNumberList(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자의 범위가 1 미만입니다.");
    }

    @Test
    void 사용자가_숫자가_아닌_문자를_입력하였을떄_예외발생() {
        //given
        String userInput;
        //when
        userInput = "w12";
        //then
        assertThatThrownBy(() -> userInputNumberList.setUserInputNumberList(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하신 값이 숫자가 아닙니다.");
    }
}