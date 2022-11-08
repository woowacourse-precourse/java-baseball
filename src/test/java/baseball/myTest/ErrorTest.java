package baseball.myTest;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

public class ErrorTest extends NsTest {

	@Test
	void 중복에러() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("133"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 길이에러() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1234"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 숫자에러1() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("12a"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 숫자에러2() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("023"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}

}
