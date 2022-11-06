package view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.view.UserInputView;

public class UserInputViewTest {

	@Test
	@DisplayName("사용자가 콘솔에 입력한 값이 제대로 입력되었는지 테스트")
	void valueEnteredByUserOnConsoleIsCorrectly() {
		// given
		String input = "123";
		InputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(byteArrayInputStream);

		// when
		String userInput = UserInputView.receiveInput();

		// then
		assertThat(userInput).isEqualTo(input);
	}
}
