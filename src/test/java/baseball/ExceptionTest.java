package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import baseball.utils.ExceptionHandler;
import camp.nextstep.edu.missionutils.test.NsTest;

public class ExceptionTest extends NsTest {
	@Test
	void 게임종료_후_재시작_예외() {
		Throwable thrown = catchThrowable(() -> assertRandomNumberInRangeTest(
				() -> run("375", "3"),
				3, 7, 5
		));
		assertSimpleTest(() ->
				assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void NULL_예외() {
		Throwable thrown = catchThrowable(() -> assertRandomNumberInRangeTest(
				() -> run("375", null),
				3, 7, 5
		));
		assertSimpleTest(() ->
				assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void 입력값_길이_예외() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("1234"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void 같은숫자_예외() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("244"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void 입력값_범위_예외() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> ExceptionHandler.checkUserException("102"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}
}
