package baseball.domain.model;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.model.User;

class UserTest {

	@Test
	@DisplayName("사용자 입력 123")
	void 사용자_입력을_객체로_저장() {
		String userInput = "123";
		Assertions.assertThat(new User(userInput)).isEqualTo(new User(List.of("1", "2", "3")));
	}

	@Test
	@DisplayName("사용자 입력 456")
	void 사용자_입력을_객체로_저장2() {
		String userInput = "456";
		Assertions.assertThat(new User(userInput)).isEqualTo(new User(List.of("4", "5", "6")));
	}
}