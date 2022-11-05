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
    void replayOrStopExceptionTest() {
        InputError inputError = new InputError();
        String answer = "2";
        assertThat(inputError.replayOrStopException(answer)).isEqualTo(answer);
    }
}