package baseball.domain.computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ComputerTest {

    private final Computer computer = spy(new Computer());

    @DisplayName("초기화 시 적어도 3번 이상 숫자 생성 메소드 호출")
    @Test
    void whenInitialize_thenCallAddNumberMethodAtLeastThreeTime() {

        //given//when
        computer.initialize();

        //then
        verify(computer,atLeast(3)).addNumber();
    }
}