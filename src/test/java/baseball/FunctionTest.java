package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {

    @DisplayName("컴퓨터 랜덤 번호의 각 자리의 범위를 검사")
    @Test
    void RandomNumberRangeTest() {
        ComputerRandomNumber computerRandomNumber = new ComputerRandomNumber();
        List<Integer> comNumber = computerRandomNumber.makeComputerNumber();
        System.out.println(comNumber);

        for (int i = 0; i < comNumber.size(); i++) {
            assertThat(comNumber.get(i)).isBetween(1, 9);
        }
    }

    @DisplayName("컴퓨가 랜덤 번호의 각 자리가 서로 다른 숫자인지 검사")
    @Test
    void RandomNumberTest() {
        ComputerRandomNumber computerRandomNumber = new ComputerRandomNumber();
        List<Integer> comNumber = computerRandomNumber.makeComputerNumber();
        System.out.println(comNumber);

        assertThat(comNumber.get(0)).isNotEqualTo(comNumber.get(1));
        assertThat(comNumber.get(0)).isNotEqualTo(comNumber.get(2));
        assertThat(comNumber.get(1)).isNotEqualTo(comNumber.get(2));
    }

    @DisplayName("게임이 끝나고 재시작 및 종료에 대한 사용자 입력이 올바른지 검사한 후 검사결과 테스트")
    @Test
    void replayOrStopExceptionCheckTest() {
        InputError inputError = new InputError();
        String answer = "2";
        assertThat(inputError.replayOrStopExceptionCheck(answer)).isEqualTo(answer);
    }

    @DisplayName("게임 중 사용자 입력이 올바른지 검사한 후 검사결과 테스트")
    @Test
    void userNumberInputExceptionCheckTest() {
        InputError inputError = new InputError();
        String answer = "981";
        assertThat(inputError.userNumberInputExceptionCheck(answer)).isEqualTo(answer);
    }

    @DisplayName("게임 중 사용자의 숫자 입력을 리스트 저장 테스트")
    @Test
    void userNumListTest() {
        UserInputToList userInputToList = new UserInputToList();
        String answer = "981";
        userInputToList.userNumList(answer);
        List<Integer> numList = userInputToList.getUserNum();

        assertThat(numList.get(0)).isEqualTo(9);
        assertThat(numList.get(1)).isEqualTo(8);
        assertThat(numList.get(2)).isEqualTo(1);
    }
}