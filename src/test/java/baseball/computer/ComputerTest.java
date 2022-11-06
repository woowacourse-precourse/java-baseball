package baseball.computer;

import static org.assertj.core.api.Assertions.*;

import baseball.game.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class ComputerTest {

    @RepeatedTest(10)
    @DisplayName("Computer 에서 정답 생성 시 Randoms.pickNumberInRange 에 의해 정상적인 Baseballs 가 생성되었는지 확인")
    public void test1() throws Exception{
        //given
        Computer computer = new Computer();
        //when
        computer.generateAnswer();
        //then
        assertThat(computer).isInstanceOf(Computer.class);
    }
}
