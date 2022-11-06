package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

	@Test
	@DisplayName("플레이어의 잘못된 입력시 예외 발생이 되는지 확인")
	void 플레이어_입력_예외_확인() {
		Game game = new Game();
		String[] testString1 = new String[] {"7", "0", "5"};
		String[] testString2 = new String[] {"@", "3", "5"};
		String[] testString3 = new String[] {"6", "a", "5"};
		String[] testString4 = new String[] {"6", "4", "5", "7"};
		String[] testString5 = new String[] {"6", "4"};

		assertThatThrownBy(() ->
				game.checkInput(testString1))
						.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() ->
				game.checkInput(testString2))
						.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() ->
				game.checkInput(testString3))
						.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() ->
				game.checkInput(testString4))
						.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() ->
				game.checkInput(testString5))
						.isInstanceOf(IllegalArgumentException.class);
	}
}
