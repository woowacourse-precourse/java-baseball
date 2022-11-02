package domain;

import org.junit.jupiter.api.Test;

public class ComputerTest {
    @Test
    void 컴퓨터_랜덤_숫자_생성(){
        Computer computer = new Computer();
        computer.make();
    }
}
