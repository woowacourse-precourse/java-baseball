package baseball.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

	private static Controller controller;

	@BeforeAll
	static void initAll() {
		controller = new Controller();
	}

	@Test
	@DisplayName("종료 입력값 2 확인")
	void 종료_입력_확인() {
		String input = "2";
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		controller.retry();
	}

	@Test
	@DisplayName("1, 2가 아닌 잘못된 입력값 입력")
	void 잘못된_입력_확인() {
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		String input1 = "3";
		InputStream in1 = new ByteArrayInputStream(input1.getBytes());
		System.setIn(in1);

		assertThatThrownBy(() ->
				controller.retry())
						.isInstanceOf(IllegalArgumentException.class);


		String input2 = "a";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);

		assertThatThrownBy(() ->
				controller.retry())
						.isInstanceOf(IllegalArgumentException.class);
	}
}
