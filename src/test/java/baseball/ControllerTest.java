package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import baseball.controller.GameController;
import baseball.dto.BaseballDto;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.test.NsTest;

public class ControllerTest extends NsTest {
	@Test
	void checkRestartErro() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> assertRandomNumberInRangeTest(
						() -> {
							run("375", "3");
						},
						3, 7, 5
				)).isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void checkResultLogic() {
		assertRandomNumberInRangeTest(
				() -> {
						run("513", "135", "1");
					assertThat(GameService.compareNumber().equals(Arrays.asList("0", "3")));
				},
				1, 3, 5
		);
	}
	//예외사항
	@Test
	void checkInputNullError() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> BaseballDto.checkErrorNumber())
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void checkInputLengthError() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> BaseballDto.checkErrorNumber())
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void checkSameInputValueError() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> BaseballDto.checkErrorNumber())
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void checkBoundaryInputError() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> BaseballDto.checkErrorNumber())
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void checkNumberInputError() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> BaseballDto.checkErrorNumber())
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}
}
