package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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
		void 결과_비교툴_스트라이크3() {
			List<Integer> computer = new ArrayList<>();
			computer.add(1);
			computer.add(3);
			computer.add(4);

			List<Integer> inputList = new ArrayList<>();
			inputList.add(1);
			inputList.add(3);
			inputList.add(4);

			ComparisonTool comparisonTool = new ComparisonTool(computer);
			ComparisonResults result = comparisonTool.compaerResult(inputList);
			assertThat(result.strike).isEqualTo(3);
			assertThat(result.ball).isEqualTo(0);
		}

		@Test
		void 결과_비교툴_볼3() {
			List<Integer> computer = new ArrayList<>();
			computer.add(1);
			computer.add(3);
			computer.add(4);

			List<Integer> inputList = new ArrayList<>();
			inputList.add(4);
			inputList.add(1);
			inputList.add(3);

			ComparisonTool comparisonTool = new ComparisonTool(computer);
			ComparisonResults result = comparisonTool.compaerResult(inputList);
			assertThat(result.strike).isEqualTo(0);
			assertThat(result.ball).isEqualTo(3);
		}

		@Test
		void 결과_비교툴_복합() {
			List<Integer> computer = new ArrayList<>();
			computer.add(1);
			computer.add(3);
			computer.add(4);

			List<Integer> inputList = new ArrayList<>();
			inputList.add(1);
			inputList.add(5);
			inputList.add(3);

			ComparisonTool comparisonTool = new ComparisonTool(computer);
			ComparisonResults result = comparisonTool.compaerResult(inputList);
			assertThat(result.strike).isEqualTo(1);
			assertThat(result.ball).isEqualTo(1);
		}

		@Test
		void 결과_비교툴_낫싱() {
			List<Integer> computer = new ArrayList<>();
			computer.add(1);
			computer.add(3);
			computer.add(4);

			List<Integer> inputList = new ArrayList<>();
			inputList.add(6);
			inputList.add(7);
			inputList.add(8);

			ComparisonTool comparisonTool = new ComparisonTool(computer);
			ComparisonResults result = comparisonTool.compaerResult(inputList);
			assertThat(result.strike).isEqualTo(0);
			assertThat(result.ball).isEqualTo(0);
		}
	}

	@Nested
	class ComparisonResultPrintTest {

		@Test
		void 결과_출력_낫싱() {
			List<Integer> computer = new ArrayList<>();
			computer.add(1);
			computer.add(3);
			computer.add(4);

			List<Integer> inputList = new ArrayList<>();
			inputList.add(6);
			inputList.add(7);
			inputList.add(8);

			ComparisonTool comparisonTool = new ComparisonTool(computer);
			ComparisonResults result = comparisonTool.compaerResult(inputList);
			assertThat(result.toString()).contains("낫싱");
		}
		
		@Test
		void 결과_출력_1스트라이크() {
			List<Integer> computer = new ArrayList<>();
			computer.add(1);
			computer.add(3);
			computer.add(4);
			
			List<Integer> inputList = new ArrayList<>();
			inputList.add(1);
			inputList.add(7);
			inputList.add(8);
			
			ComparisonTool comparisonTool = new ComparisonTool(computer);
			ComparisonResults result = comparisonTool.compaerResult(inputList);
			assertThat(result.toString()).contains("1스트라이크");
		}
		
		@Test
		void 결과_출력_1볼() {
			List<Integer> computer = new ArrayList<>();
			computer.add(1);
			computer.add(3);
			computer.add(4);
			
			List<Integer> inputList = new ArrayList<>();
			inputList.add(4);
			inputList.add(7);
			inputList.add(8);
			
			ComparisonTool comparisonTool = new ComparisonTool(computer);
			ComparisonResults result = comparisonTool.compaerResult(inputList);
			assertThat(result.toString()).contains("1볼");
		}
		
		@Test
		void 결과_출력_1볼_1스트라이크() {
			List<Integer> computer = new ArrayList<>();
			computer.add(1);
			computer.add(3);
			computer.add(4);
			
			List<Integer> inputList = new ArrayList<>();
			inputList.add(4);
			inputList.add(3);
			inputList.add(8);
			
			ComparisonTool comparisonTool = new ComparisonTool(computer);
			ComparisonResults result = comparisonTool.compaerResult(inputList);
			assertThat(result.toString()).contains("1볼 1스트라이크");
		}
	}
}
