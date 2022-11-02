package baseball;

import constant.Messages;
import domain.Number;
import domain.Numbers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest{

    @Test
    void 모두_스트라이크_문구_출력_확인() {
        List<Number> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            list.add(new Number(i));
        }
        Numbers cNum = new Numbers(list);
        Numbers uNum = new Numbers(list);

        Result result = new Result(cNum, uNum);
        assertEquals(result.getResult(), Messages.successMessage);
    }
}
