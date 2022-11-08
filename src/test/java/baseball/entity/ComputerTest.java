package baseball.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTest {

    @Test
    @DisplayName("Computer 인스턴스를 생성할 때 size 3의 List를 갖는지 테스트")
    void computerNumberListTest() {
        // given, when
        Computer computer = new Computer();
        List<Integer> computerNumberList = computer.getComputerNumberList();

        // then
        assertEquals(computerNumberList.size(), 3);
    }
}
