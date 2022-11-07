package baseball;

import baseball.domain.User;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

    @Test
    void 예외_테스트_길이() {
        String answer = "1234";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> User.userNumberLength(answer))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    
    @Test
    void 예외_테스트_범위밖() {
    	String answer = "108";
    	
    	assertSimpleTest(() ->
    			assertThatThrownBy(() -> User.userNumberRange(answer))
    					.isInstanceOf(IllegalArgumentException.class)
    	);
    }
    
    @Test
    void 예외_테스트_중복() {
        String answer = "222";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> User.userNumberSameCheck(answer))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_재시작_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> User.finishNumber("3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}