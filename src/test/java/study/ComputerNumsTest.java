package study;

import baseball.ComputerNums;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ComputerNumsTest {

    //@Test
    void 컴퓨터_랜덤_숫자_생성_확인() {
        int computerNumsLen = 3;
        ComputerNums computerNums = new ComputerNums();
        System.out.println(computerNums.getNums());
        assertThat(computerNums.getNums().size()).isEqualTo(computerNumsLen);
    }


}