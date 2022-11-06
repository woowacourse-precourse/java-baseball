package baseball;

import baseball.domain.Computer;

import baseball.view.PrintView;
import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashSet;

class ApplicationTest extends NsTest {

	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	void 세자리_수를_랜덤으로_생성() {
		Computer computer = new Computer();
		computer.createAnswer();

		assertThat(new HashSet<>(computer.getAnswer()))
			.size()
			.isEqualTo(3);

		for (int i = 0; i < 3; i++) {
			assertThat(computer.getAnswer()
				.get(i))
				.isBetween(1, 9);
		}
	}

	@Nested
	@DisplayName("세자리 수를 입력 받음")
	class inputNum {

		@Test
		@DisplayName("숫자만 입력하지 않았을 때")
		void convertError() {
			assertThatThrownBy(() -> runException("r24"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("숫자만 입력해주세요");
		}

		@Test
		@DisplayName("세자리 수가 아닐때")
		void sizeError() {
			assertThatThrownBy(() -> runException("1234"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("세 자리수를 입력해주세요");
		}

		@Test
		@DisplayName("각 자리수가 다르지 않을때")
		void duplicateError() {
			assertThatThrownBy(() -> runException("223"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("각 자리수가 다르게 입력해주세요");
		}

		@Test
		@DisplayName("각 자리수의 범위가 1-9를 벗어날때")
		void numberError() {
			assertThatThrownBy(() -> runException("021"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("각 자리수의 범위를 맞춰주세요");
		}

	}

	@Test
	void 볼과_스트라이크_개수에_맞는_출력값을_출력한다() {

		PrintView.printHint(1, 2);
		Assertions.assertEquals("1볼 2스트라이크", outputStreamCaptor.toString()
			.trim());
	}

	@Test
	void 게임종료_후_재시작() {
		assertRandomNumberInRangeTest(
			() -> {
				run("246", "135", "1", "597", "589", "2");
				assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
			},
			1, 3, 5, 5, 8, 9
		);
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1234"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
