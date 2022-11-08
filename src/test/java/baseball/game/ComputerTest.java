package baseball.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    @Test
    public void drawComputerTest() throws Exception{
        //given
        Computer computer = new Computer();
        //expect
        System.out.println(computer.getAnswer());

    }

}