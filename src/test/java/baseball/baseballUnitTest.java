package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static util.GameUtil.INPUT_DUPLICATION_ERROR;
import static util.GameUtil.INPUT_RANGE_ERROR;
import static util.GameUtil.INPUT_TYPE_ERROR;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class baseballUnitTest {

	@Nested
	@DisplayName("유저 입력값 검증")
	class InputTestCase {

		@Test
		@DisplayName("유저 입력값 범위 오류")
		void rangeTestCase() {
			assertThatThrownBy(() -> new Exception().check("12"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(INPUT_RANGE_ERROR);
			assertThatThrownBy(() -> new Exception().check("1234"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(INPUT_RANGE_ERROR);
		}

		@Test
		@DisplayName("유저 입력값 형식 오류")
		void 문자입력() {
			assertThatThrownBy(() -> new Exception().check("12a"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(INPUT_TYPE_ERROR);
		}

		@Test
		@DisplayName("중복 숫자 입력")
		void 중복숫자() {
			assertThatThrownBy(() -> new Exception().check("121"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(INPUT_DUPLICATION_ERROR);
		}
	}

	@Nested
	@DisplayName("게임 기능 검증")
	class baseballGameTestCase {

		@Test
		@DisplayName("3스트라이크 가 이닐때 계속되는지 심사 refereeBalls method test")
		public void refereeBallsTestCase() {
			BaseballUmpire baseballUmpire = new BaseballUmpire();
			ArrayList<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));

			assertThat(baseballUmpire.refereeBalls("123", computer)).isEqualTo(false);
			assertThat(baseballUmpire.refereeBalls("423", computer)).isEqualTo(true);
			assertThat(baseballUmpire.refereeBalls("231", computer)).isEqualTo(true);
		}

		@Test
		@DisplayName("스트라이크인지 볼인지 심사하기")
		void refereeBallTestCase() {
			BaseballUmpire baseballUmpire = new BaseballUmpire();
			try {
				Method refereeBall = baseballUmpire.getClass()
					.getDeclaredMethod("refereeBall", boolean.class, boolean.class);
				Field strike = baseballUmpire.getClass().getDeclaredField("strike");
				Field ball = baseballUmpire.getClass().getDeclaredField("ball");
				refereeBall.setAccessible(true);
				strike.setAccessible(true);
				ball.setAccessible(true);

				refereeBall.invoke(baseballUmpire, true, true);
				assertThat((int) strike.get(baseballUmpire)).isEqualTo(1);
				assertThat((int) ball.get(baseballUmpire)).isEqualTo(0);
				refereeBall.invoke(baseballUmpire, true, false);
				assertThat((int) ball.get(baseballUmpire)).isEqualTo(1);
				assertThat((int) strike.get(baseballUmpire)).isEqualTo(1);
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		}

		@Test
		@DisplayName("스트라이크인지 볼인지 심사하기")
		void compareBallsTestCase() {
			BaseballUmpire baseballUmpire = new BaseballUmpire();
			try {
				Method compareBalls = baseballUmpire.getClass()
					.getDeclaredMethod("compareBalls", int.class, ArrayList.class, int.class);
				Field strike = baseballUmpire.getClass().getDeclaredField("strike");
				Field ball = baseballUmpire.getClass().getDeclaredField("ball");
				ArrayList<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
				compareBalls.setAccessible(true);
				strike.setAccessible(true);
				ball.setAccessible(true);

				compareBalls.invoke(baseballUmpire, 1, computer, 0);
				assertThat((int) strike.get(baseballUmpire)).isEqualTo(1);
				assertThat((int) ball.get(baseballUmpire)).isEqualTo(0);
				compareBalls.invoke(baseballUmpire, 3, computer, 1);
				assertThat((int) ball.get(baseballUmpire)).isEqualTo(1);
				assertThat((int) strike.get(baseballUmpire)).isEqualTo(1);
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		}


		@Test
		@DisplayName("print hint test (3스크라이크)")
		void ConsoleTestCase() {
			OutputStream out = new ByteArrayOutputStream();
			System.setOut(new PrintStream(out));
			ArrayList<Integer> computer = new ArrayList<>(Arrays.asList(1, 5, 4));
			final String message = 3 + "스트라이크\r\n";

			Console.printHint(3, 0);
			assertThat(message).isEqualTo(out.toString());
		}
	}

}
