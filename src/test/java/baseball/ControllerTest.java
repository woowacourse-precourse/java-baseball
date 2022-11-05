package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import baseball.controller.GameController;

public class ControllerTest {
	//예외사항
	@Test
	void checkInputNullError() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> GameController.checkErrorNumber(null))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void checkInputLengthError() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> GameController.checkErrorNumber("1234"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void checkSameInputValueError() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> GameController.checkErrorNumber("4588"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void checkBoundaryInputError() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> GameController.checkErrorNumber("1250"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void checkNumberInputError() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> GameController.checkErrorNumber("abcd"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	//결과
	@Test
	void checkResultOneBall() {
		assertThat(GameController.compareNumber("123", "451")).isEqualTo(Arrays.asList(0,1));
	}
	@Test
	void checkResultTwoBall() {
		assertThat(GameController.compareNumber("123", "431")).isEqualTo(Arrays.asList(0,2));
	}
	@Test
	void checkResultThreeBall() {
		assertThat(GameController.compareNumber("123", "312")).isEqualTo(Arrays.asList(0, 3));
	}
	@Test
	void checkResultOneStrike() {
		assertThat(GameController.compareNumber("123", "426")).isEqualTo(Arrays.asList(1, 0));
	}
	@Test
	void checkResultTwoStrike() {
		assertThat(GameController.compareNumber("123", "143")).isEqualTo(Arrays.asList(2, 0));
	}
	@Test
	void checkResultThreeStrike() {
		assertThat(GameController.compareNumber("123", "123")).isEqualTo(Arrays.asList(3, 0));
	}
	@Test
	void checkResultOneStrikeOneBall() {
		assertThat(GameController.compareNumber("123", "142")).isEqualTo(Arrays.asList(1, 1));
	}
	@Test
	void checkResultOneStrikeTwoBall() {
		assertThat(GameController.compareNumber("123", "321")).isEqualTo(Arrays.asList(1, 2));
	}
	@Test
	void checkResultNothing() {
		assertThat(GameController.compareNumber("123", "456")).isEqualTo(Arrays.asList(0, 0));
	}
}
