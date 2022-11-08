package baseball.printer;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import baseball.model.BaseballResponse;

class BaseballPrinterTest {

	private final BaseballPrinter baseballPrinter = new BaseballPrinter();
	private ByteArrayOutputStream outputStreamCaptor;
	private PrintStream standardOut;

	protected void systemIn(String input) {
		System.setIn(new ByteArrayInputStream(input.getBytes()));
	}

	@AfterEach
	protected void printResult() {
		System.setOut(standardOut);
		System.out.println(getOutput());
	}

	protected String getOutput() {
		return outputStreamCaptor.toString();
	}

	@BeforeEach
	void setUp() {
		standardOut = System.out;
		outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Nested
	class Print {

		@Test
		@DisplayName("볼 카운트가 2이면 2볼을 출력한다.")
		void case1() throws Exception {
			// given
			final int strike = 0;
			final int ball = 2;
			final BaseballResponse response = BaseballResponse.of(strike, ball);
			final String expected = "2볼";
			systemIn(expected);

			// when
			baseballPrinter.print(response);

			// then
			assertThat(getOutput()).contains(expected);
		}

		@Test
		@DisplayName("스트라이크 카운트가 3이면 3스트라이크를 출력한다.")
		void case2() throws Exception {
			// given
			final int strike = 3;
			final int ball = 0;
			final BaseballResponse response = BaseballResponse.of(strike, ball);
			final String expected = "3스트라이크";
			systemIn(expected);

			// when
			baseballPrinter.print(response);

			// then
			assertThat(getOutput()).contains(expected);
		}

		@Test
		@DisplayName("볼 카운트가 1이고 스트라이크 카운트가 2이면 1볼 2스트라이크를 출력한다.")
		void case3() throws Exception {
			// given
			final int strike = 2;
			final int ball = 1;
			final BaseballResponse response = BaseballResponse.of(strike, ball);
			final String expected = "1볼 2스트라이크";
			systemIn(expected);

			// when
			baseballPrinter.print(response);

			// then
			assertThat(getOutput()).contains(expected);
		}

		@Test
		@DisplayName("볼 카운트와 스트라이크 카운트가 모두 0이면 낫싱을 출력한다.")
		void case4() throws Exception {
			// given
			final int strike = 0;
			final int ball = 0;
			final BaseballResponse response = BaseballResponse.of(strike, ball);
			final String expected = "낫싱";
			systemIn(expected);

			// when
			baseballPrinter.print(response);

			// then
			assertThat(getOutput()).contains(expected);
		}

	}

}