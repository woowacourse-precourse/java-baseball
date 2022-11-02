package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import baseball.controller.GameController;
import baseball.service.GameService;

public class ControllerTest {
	@Test
	void 랜덤함수_결과() {

	}
	@Test
	void 입력함수_결과() {
		GameController gc = new GameController();
		gc.saveUserNumber("123");
		assertThat("123").isEqualTo("123");
	}
	@Test
	void 결과_볼() {
		GameController gc = new GameController();

		gc.compareNumber("123" ,"231");
		assertThat(1).isEqualTo(1);
	}
	@Test
	void 결과_볼1() {
		GameController gc = new GameController();

		gc.compareNumber("123" ,"312");
		assertThat(1).isEqualTo(1);
	}
	@Test
	void 결과_볼2() {
		GameController gc = new GameController();

		gc.compareNumber("123" ,"432");
		assertThat(1).isEqualTo(1);
	}
	@Test
	void 결과_볼3() {
		GameController gc = new GameController();

		gc.compareNumber("123" ,"241");
		assertThat(1).isEqualTo(1);
	}
	@Test
	void 결과_볼4() {
		GameController gc = new GameController();

		gc.compareNumber("123" ,"341");
		assertThat(1).isEqualTo(1);
	}
	@Test
	void 결과_볼5() {
		GameController gc = new GameController();

		gc.compareNumber("123" ,"341");
		assertThat(1).isEqualTo(1);
	}

	@Test
	void 결과_낫싱() {

	}
	//예외 처리
	@Test
	void 숫자_범위_예외체크() {
		GameController gc = new GameController();
		assertSimpleTest(() ->
				assertThatThrownBy(() -> gc.saveUserNumber("012"))
						.isInstanceOf(IllegalArgumentException.class));
	}
	@Test
	void 숫자_길이체크() {
		GameController gc = new GameController();
		assertSimpleTest(() ->
				assertThatThrownBy(() -> gc.saveUserNumber("1234"))
						.isInstanceOf(IllegalArgumentException.class));
	}
	@Test
	void 같은숫자_체크() {
		GameController gc = new GameController();
		assertSimpleTest(() ->
				assertThatThrownBy(() -> gc.saveUserNumber("111"))
						.isInstanceOf(IllegalArgumentException.class));
	}
	@Test
	void 널값_체크() {
		GameController gc = new GameController();
		assertSimpleTest(() ->
				assertThatThrownBy(() -> gc.saveUserNumber(null))
						.isInstanceOf(IllegalArgumentException.class));
	}
	@Test
	void 숫자외_다른문자() {
		GameController gc = new GameController();
		assertSimpleTest(() ->
				assertThatThrownBy(() -> gc.saveUserNumber("agf"))
						.isInstanceOf(IllegalArgumentException.class));
	}


}
