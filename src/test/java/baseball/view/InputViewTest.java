package baseball.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {
	@Test
	void getRestartOrEndCodeTest_예외입력(){
		InputView iv = new InputView();
		ByteArrayInputStream is = new ByteArrayInputStream("test".getBytes());
		System.setIn(is);
		Assertions.assertThatThrownBy(() -> iv.getRestartOrEndCode())
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void getRestartOrEndCodeTest_정상입력(){
		InputView iv = new InputView();

		ByteArrayInputStream is = new ByteArrayInputStream("1".getBytes());
		System.setIn(is);

		Assertions.assertThat(iv.getRestartOrEndCode()).isEqualTo("1");

		is = new ByteArrayInputStream("2".getBytes());
		System.setIn(is);

		Assertions.assertThat(iv.getRestartOrEndCode()).isEqualTo("2");
	}
}