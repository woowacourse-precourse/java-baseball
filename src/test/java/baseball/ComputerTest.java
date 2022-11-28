package baseball;

import baseball.model.Computer;
import baseball.model.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComputerTest {

    @Test
    @DisplayName("상대방(컴퓨터) 수 검증")
    void validateComputer() {
        String tmp = "";
        List<Integer> computer = new Computer().get();
        for (int i = 0; i < computer.size(); i++) {
            tmp += "" + computer.get(i);
        }
        Validator.validateNum(tmp);
    }
}
