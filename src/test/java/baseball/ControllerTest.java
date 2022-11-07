package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import baseball.service.GameService;
import baseball.utils.ExceptionHandler;
import camp.nextstep.edu.missionutils.test.NsTest;

public class ControllerTest extends NsTest {
	@Test
	void checkRestartError() {
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
				assertThatThrownBy(() -> ExceptionHandler.checkUserException(null))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void checkInputLengthError() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> ExceptionHandler.checkUserException("1234"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void checkSameInputValueError() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> ExceptionHandler.checkUserException("244"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Test
	void checkBoundaryInputError() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> ExceptionHandler.checkUserException("102"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}
}
