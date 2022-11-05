package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class FunctionTest {

	@Nested
	class ComputerRandomIntegerTest {
		@Test
		void 컴퓨터_랜덤숫자_길이확인() {
			List<Integer> computer = BaseballUtil.getRandomInteger();
			// list 사이즈 확인
			assertThat(computer).hasSize(3);
			// 중복 여부 확인
			for (Integer number : computer) {
				assertThat(computer).containsOnlyOnce(number);
			}
		}
	}

	@Nested
	class UserInputIntegerTest {
		@Test
		void 사용자_입력값_유효성확인_길이넘침() {
			String input = "1234";
			SetSystemInput(input);
			assertThatThrownBy(() -> BaseballUtil.getUserInteger()).isInstanceOf(IllegalArgumentException.class);

		}

		@Test
		void 사용자_입력값_유효성확인_길이부족() {
			String input = "12";
			SetSystemInput(input);
			assertThatThrownBy(() -> BaseballUtil.getUserInteger()).isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		void 사용자_입력값_유효성확인_숫자외문자입력() {
			String input = "12a";
			SetSystemInput(input);
			assertThatThrownBy(() -> BaseballUtil.getUserInteger()).isInstanceOf(IllegalArgumentException.class);

		}

		@Test
		void 사용자_입력값_유효성확인_중복숫자입력() {
			String input = "122";
			SetSystemInput(input);
			assertThatThrownBy(() -> BaseballUtil.getUserInteger()).isInstanceOf(IllegalArgumentException.class);

		}
		
		@Test
		void 사용자_입력값_유효성확인_0입력() {
			String input = "102";
			SetSystemInput(input);
			assertThatThrownBy(() -> BaseballUtil.getUserInteger()).isInstanceOf(IllegalArgumentException.class);
			
		}

		@Test
		void 사용자_입력값_Integer_List_반환() {
			String input = "123";
			SetSystemInput(input);
			List<Integer> inputList = BaseballUtil.getUserInteger();

			assertThat(inputList).contains(1, 2, 3);
		}
		public void SetSystemInput(String input) {
			OutputStream out = new ByteArrayOutputStream();
			System.setOut(new PrintStream(out));
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
		}

	}

	@Nested
	class ComparisonToolTest {
		@Test
		void 비교툴() {
			List<Integer> computer = BaseballUtil.getRandomInteger();
			ComparisonTool comparisonTool = new ComparisonTool(computer);
			String input = "123";
			SetSystemInput(input);
			List<Integer> inputList = BaseballUtil.getUserInteger();
			ComparisonResults result = comparisonTool.compaerResult(inputList);
			System.out.println(12312);
			
			
		}
		public void SetSystemInput(String input) {
			OutputStream out = new ByteArrayOutputStream();
			System.setOut(new PrintStream(out));
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
		}
	}

}
