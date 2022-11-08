package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.*;


import static baseball.Application.*;
import static org.assertj.core.api.Assertions.*;

public class MethodTest extends NsTest {


    @Test
    void 랜덤_숫자_생성테스트(){
        ArrayList<Integer> computer = new ArrayList<>();
        randomComputer(computer);
        int result = 3;
        assertThat(randomComputer(computer).size()).isEqualTo(result);

    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

