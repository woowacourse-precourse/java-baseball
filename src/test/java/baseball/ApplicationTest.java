package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

	@Test
	@DisplayName("컴퓨터가 1부터 9까지의 숫자만 생성하는지")
	void 랜덤생성숫자_1부터_9까지인지() {
		Computer computer = new Computer();
		List<Integer> computerNumbers = computer.getNumbers();

		for (int i = 0; i < computerNumbers.size(); i++) {
			assertThat(computerNumbers.get(i)).isBetween(1, 9);
		}
	}

	@Test
	@DisplayName("컴퓨터에 생성된 세 숫자가 서로 중복되지 않는지")
	void 랜덤생성숫자_중복_여부_확인() {
		Computer computer = new Computer();
		List<Integer> computerNumbers = computer.getNumbers();

		assertThat(computerNumbers.get(0)).isNotEqualTo(computerNumbers.get(1)).isNotEqualTo(computerNumbers.get(2));
	}


	@Test
	@DisplayName("유저가 입력한 문자열이 Integer ArrayList로 잘 변환되는지 확인.")
	void 입력_문지열_Integer_ArrayList_변환_확인() {
		String testNumberString = "123";
		InputStream inputStream = new ByteArrayInputStream(testNumberString.getBytes());

		String inputString = new BufferedReader(
			new InputStreamReader(inputStream, StandardCharsets.UTF_8))
			.lines()
			.collect(Collectors.joining("\n"));

		List<Integer> expectNumbers = List.of(1, 2, 3);

		User user = new User(inputString);
		assertThat(user.getNumbers()).isEqualTo(expectNumbers);

	}

	@Test
	@DisplayName("3개 이상의 숫자 입력시 예외처리")
	void 네개이상_숫자입력_예외처리() throws IllegalArgumentException {
		String testNumberString = "1234";
		InputStream inputStream = new ByteArrayInputStream(testNumberString.getBytes());

		String inputString = new BufferedReader(
			new InputStreamReader(inputStream, StandardCharsets.UTF_8))
			.lines()
			.collect(Collectors.joining("\n"));

		assertThatThrownBy(()->new User(inputString))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("숫자를 총 3개 입력해주세요.");
	}
	@Test
	@DisplayName("숫자야구에 0 입력시 예외처리")
	void 숫자입력_0입력시_예외처리() throws IllegalArgumentException {
		String testNumberString = "103";
		InputStream inputStream = new ByteArrayInputStream(testNumberString.getBytes());

		String inputString = new BufferedReader(
			new InputStreamReader(inputStream, StandardCharsets.UTF_8))
			.lines()
			.collect(Collectors.joining("\n"));

		assertThatThrownBy(()->new User(inputString))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("1부터 9까지의 숫자만 입력해주세요.");
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
		Application.main(new String[]{});
	}
}
