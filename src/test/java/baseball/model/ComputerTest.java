package baseball.model;

import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void 컴퓨터_랜덤숫자_생성() {
        Computer computer = new Computer();
        System.out.println(computer.setAnswer(Random.createRandomNumber()));
    }
}