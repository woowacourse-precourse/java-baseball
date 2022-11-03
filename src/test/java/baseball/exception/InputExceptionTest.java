package baseball.exception;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

class InputExceptionTest extends NsTest {

	@Test
	void containZeroExceptionTest() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("102"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void duplicateNumberExceptionTest() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("133"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void isNumberExceptionTest() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1a3"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void restartOrExitInputExceptionTest() {
		String input = "3";
		assertThatThrownBy(() -> InputException.isRestartOrExitNumber(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
