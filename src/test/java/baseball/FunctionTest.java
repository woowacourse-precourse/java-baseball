package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Test;

public class FunctionTest extends NsTest {

	@Test
	void TestSetComputersList() {
		Computer computer = new Computer();
		computer.setComputersList();

		for(int i = 0; i < 3; i++) {
			assertThat(computer.computersList.get(i)).isBetween(1, 9);
		}

		assertThat(computer.computersList.size()).isEqualTo(3);
	}

	@Test
	void TestStatus() {
		Status status = new Status();
		assertThat(status.getStatus()).isEqualTo("INIT");
		status.setStatusPlaying();
		assertThat(status.getStatus()).isEqualTo("PLAYING");
		status.setStatusTerminating();
		assertThat(status.getStatus()).isEqualTo("TERMINATING");
	}

	@Test
	void TestPatternValidation() {
		User user = new User();

		user.userInput = "123";
		user.patternValidateInput();
		assertThat(user.patternedUserInput).isEqualTo(user.userInput);

		user.userInput = "1234";
		assertThatThrownBy(() -> {user.patternValidateInput();}).isInstanceOf(IllegalArgumentException.class);

		user.userInput = "asdf";
		assertThatThrownBy(() -> {user.patternValidateInput();}).isInstanceOf(IllegalArgumentException.class);

		user.userInput = "1";
		assertThatThrownBy(() -> {user.patternValidateInput();}).isInstanceOf(IllegalArgumentException.class);

		user.userInput = "a";
		assertThatThrownBy(() -> {user.patternValidateInput();}).isInstanceOf(IllegalArgumentException.class);

		user.userInput = "1a";
		assertThatThrownBy(() -> {user.patternValidateInput();}).isInstanceOf(IllegalArgumentException.class);

		user.userInput = "12as";
		assertThatThrownBy(() -> {user.patternValidateInput();}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void TestDuplicationValidation() {
		User user = new User();

		user.patternedUserInput = "123";
		user.duplicationValidateInput();
		assertThat(user.getValidatedUserInput()).containsExactly(1, 2, 3);

		user.patternedUserInput = "111";
		assertThatThrownBy(() -> {user.duplicationValidateInput();}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void TestAnswerValidation() {
		User user = new User();

		user.userInput = "1";
		user.answerValidateInput();
		assertThat(user.getValidatedUserInput()).containsExactly(1);
		assertThat(user.getValidatedUserInput().size()).isEqualTo(1);

		user.userInput = "111";
		assertThatThrownBy(() -> {user.answerValidateInput();}).isInstanceOf(IllegalArgumentException.class);

		user.userInput = "3";
		assertThatThrownBy(() -> {user.answerValidateInput();}).isInstanceOf(IllegalArgumentException.class);

		user.userInput = "asdf";
		assertThatThrownBy(() -> {user.answerValidateInput();}).isInstanceOf(IllegalArgumentException.class);

		user.userInput = "";
		assertThatThrownBy(() -> {user.answerValidateInput();}).isInstanceOf(IllegalArgumentException.class);
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}
}
