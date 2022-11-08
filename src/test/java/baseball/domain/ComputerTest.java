package baseball.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("컴퓨터 객체의 기능 테스트 코드 작성")
public class ComputerTest {

    @DisplayName("서로 다른 1 ~ 9 까지의 수를 고르는 기능")
    @Test
    void givenComputer_whenChoose_thenReturnNumbersChosenByTheComputer(){
        // Given
        Computer computer = new Computer();

        // When
        computer.chooseThreeNumbers();
        ArrayList<Integer> numbersChosenByTheComputer = computer.getNumbersChosenByTheComputer();

        // Then
        assertThat(numbersChosenByTheComputer.size()).isEqualTo(3);
        assertThat(numbersChosenByTheComputer.stream().distinct().count()).isEqualTo(3);
    }
}
