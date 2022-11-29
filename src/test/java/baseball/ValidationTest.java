package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.domain.Player;
import camp.nextstep.edu.missionutils.test.NsTest;

public class ValidationTest extends NsTest {
	Player player = new Player();

	@ParameterizedTest()
	@ValueSource(strings = {"ㅁ", "1234", "012"})
	void validatePlayerInput_메서드로_숫자_맞추기_입력_검증(String input) {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException(input))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void validateSameLetter_메서드로_중복_숫자_검증() {
		String input = "123";

		player.addPlayerNumberInList(input);

		boolean isSameNumberExist = player.getPlayerNumberList().stream()
			.distinct()
			.count() != player.getPlayerNumberList().size();

		assertThat(isSameNumberExist).isFalse();
	}

	@Test
	void 사용자_입력_범위_테스트() {
		String input = "123";
		player.addPlayerNumberInList(input);

		assertThat(player.getPlayerNumberList().stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
	}

	@Test
	void 사용자_입력_숫자_테스트() {
		String input = "123";
		System.out.println(input);
		assertThat(input.length()).isEqualTo(3);
	}


	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
