package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    @DisplayName("정상 값")
    void getInput() {
        //given
        //when
        Computer opponent = new Computer();

        //then
        System.out.println(opponent.getComputer());
    }
}