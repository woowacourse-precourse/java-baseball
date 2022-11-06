package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import baseball.model.Referee;
import baseball.utility.Utility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class RefereeTest extends NsTest {
    @Test
    void 기능4_사용자_입력_판정_테스트(){
        Referee referee = new Referee();
        List<Integer> testComputerNumber = List.of(1,2,3);
        assertThat(referee.judge(123, testComputerNumber)).isEqualTo(String.format(Utility.STRIKE_MESSAGE, 3));
        System.out.println("test4 (userInput = 123), (computerNum = 123) : " + referee.judge(123, testComputerNumber));
        
        assertThat(referee.judge(543, testComputerNumber)).isEqualTo(String.format(Utility.STRIKE_MESSAGE, 1));
        System.out.println("test4 (userInput = 543), (computerNum = 123) : " + referee.judge(543, testComputerNumber));
        
        assertThat(referee.judge(345, testComputerNumber)).isEqualTo(String.format(Utility.BALL_MESSAGE, 1));
        System.out.println("test4 (userInput = 345), (computerNum = 123) : " + referee.judge(345, testComputerNumber));
        
        assertThat(referee.judge(325, testComputerNumber)).isEqualTo(String.format(Utility.BALL_MESSAGE, 1)+" "+String.format(Utility.STRIKE_MESSAGE, 1));
        System.out.println("test4 (userInput = 325), (computerNum = 123) : " + referee.judge(325, testComputerNumber));

        assertThat(referee.judge(456, testComputerNumber)).isEqualTo(Utility.NOTHING_MESSAGE);
        System.out.println("test4 (userInput = 456), (computerNum = 123) : " + referee.judge(456, testComputerNumber));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
    
}
