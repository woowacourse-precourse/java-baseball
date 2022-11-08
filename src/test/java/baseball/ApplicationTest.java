package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
   
    @Test
    void 예외_테스트_세자리숫자_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 예외_테스트_중복된_숫자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("333"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 예외_테스트_숫자가_아닌_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aa3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 입력받은_문자를_List에_저장() {
    	Application application=new Application();
    	String input = "135";
    	List<Integer> result=List.of(1,3,5);
    	assertThat(application.userNumber(input).equals(result));
    }
    
    @Test
    void 입력받은_문자를_비교하기_3스트라이크() {
    	Application application=new Application();
    	List<Integer> computer=List.of(1,3,5);
    	List<Integer> user=List.of(1,3,5);
    	int strike=application.strikeCheck(computer, user);
    	int ball=application.ballCheck(computer, user);
    	String result="3스트라이크\n";
				result+="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    	assertThat(application.gameResult(strike, ball).equals(result));
    }
    
    @Test
    void 입력받은_문자를_비교하기_낫싱() {
    	Application application=new Application();
    	List<Integer> computer=List.of(1,3,5);
    	List<Integer> user=List.of(2,4,6);
    	int strike=application.strikeCheck(computer, user);
    	int ball=application.ballCheck(computer, user);
    	String result="3스트라이크\n";
				result+="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    	assertThat(application.gameResult(strike, ball).equals(result));
    }
    
    @Test
    void 입력받은_문자를_비교하기_1볼_1스트라이크() {
    	Application application=new Application();
    	List<Integer> computer=List.of(1,3,5);
    	List<Integer> user=List.of(1,5,9);
    	int strike=application.strikeCheck(computer, user);
    	int ball=application.ballCheck(computer, user);
    	String result="3스트라이크\n";
				result+="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    	assertThat(application.gameResult(strike, ball).equals(result));
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
