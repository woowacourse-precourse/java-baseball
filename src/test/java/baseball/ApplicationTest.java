package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.service.Service;
import baseball.service.vo.ServiceVO;
import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
	
	@DisplayName("볼 카운트") 
    @Test
    void testSetBall() {
		ServiceVO vo = new ServiceVO();
		vo.setBall(1);
		assertThat(vo.getBall()).isEqualTo(1);
    }
	
	@DisplayName("스트라이크 카운트") 
    @Test
    void testSetStrike() {
		ServiceVO vo = new ServiceVO();
		vo.setStrike(3);
		assertThat(vo.getStrike()).isEqualTo(3);
    }
	
	@DisplayName("컴퓨터 숫자 테스트") 
    @Test
    void comNuberTest() {		
		ServiceVO vo = new ServiceVO();
		List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
		vo.setComputerNumbers(computerNumbers);
		assertThat(vo.getComputerNumbers().toString()).isEqualTo("[1, 2, 3]");
    }
	
	@DisplayName("유저 숫자 테스트") 
    @Test
    void userNumberTest() {		
		ServiceVO vo = new ServiceVO();
		String userNumbers = "729";
		vo.setUserAnotherNumbers(userNumbers);
		assertThat(vo.getUserAnotherNumbers().toString()).isEqualTo("729");
    }

    @DisplayName("범위에 벗어난 입력")
    @Test
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @DisplayName("공란 입력")
    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @DisplayName("문자열 입력")
    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @DisplayName("중복 체크")
    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
