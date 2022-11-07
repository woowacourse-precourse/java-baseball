package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import baseball.constants.Constants;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 스트라이크_볼_1볼_1스() {
    	Integer[] randomNumber = {6, 3, 2};
    	Integer[] userNumber = {3, 1, 2};
    	ArrayList<Integer> randomList = new ArrayList<>(Arrays.asList(randomNumber));
    	ArrayList<Integer> userList = new ArrayList<>(Arrays.asList(userNumber));
    	
    	Controller controller = new Controller();
    	controller.computerNumber = randomList;
    	controller.checkStrike(userList);
    	controller.checkBall(userList);
    	
    	Constants.message(controller.strike, controller.ball);
    	String resultMsg = "1볼 1스트라이크";
    	
    	assertThat(resultMsg).isEqualTo(output().toString());
    }
    
    @Test
    void 스트라이크_볼_3스() {
    	Integer[] randomNumber = {3, 1, 2};
    	Integer[] userNumber = {3, 1, 2};
    	ArrayList<Integer> randomList = new ArrayList<>(Arrays.asList(randomNumber));
    	ArrayList<Integer> userList = new ArrayList<>(Arrays.asList(userNumber));
    	
    	Controller controller = new Controller();
    	controller.computerNumber = randomList;
    	controller.checkStrike(userList);
    	controller.checkBall(userList);
    	
    	Constants.message(controller.strike, controller.ball);
    	String resultMsg = "3스트라이크";
    	
    	assertThat(resultMsg).isEqualTo(output().toString());
    }
    
    @Test
    void 스트라이크_볼_낫싱() {
    	Integer[] randomNumber = {7, 8, 9};
    	Integer[] userNumber = {3, 1, 2};
    	ArrayList<Integer> randomList = new ArrayList<>(Arrays.asList(randomNumber));
    	ArrayList<Integer> userList = new ArrayList<>(Arrays.asList(userNumber));
    	
    	Controller controller = new Controller();
    	controller.computerNumber = randomList;
    	controller.checkStrike(userList);
    	controller.checkBall(userList);
    	
    	Constants.message(controller.strike, controller.ball);
    	String resultMsg = "낫싱";
    	
    	assertThat(resultMsg).isEqualTo(output().toString());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
