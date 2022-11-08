package baseball;

import org.junit.jupiter.api.Test;


import static baseball.Application.makeComputerNum;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static baseball.Application.makeRandomNum;

public class TestCode {

    @Test
    void makeRandomNum_특정_범위의_값을_반환(){
        int result;
        List<Integer> Input = new ArrayList<>();
        result = makeRandomNum(Input);
        assertThat(result).isBetween(1,9);
    }

    @Test
    void makeComputerNum_세_자리의_수_반환(){
        List<Integer> result = makeComputerNum();
        assertThat(result.size()).isEqualTo(3);
    }

}
