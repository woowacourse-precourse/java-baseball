package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTest {
    @Test
    void 컴퓨터_수_생성() {
        ArrayList<String> numberList = Computer.createNumber();

        assertEquals(numberList.size(),3);
    }
}
