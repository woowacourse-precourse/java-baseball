package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class IOHandlerTest {

	final IOHandler io = new IOHandler();
	final OutputStream outputStream = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() {
		System.setOut(new PrintStream(outputStream));
	}

	@AfterEach
	void tearDown() {
		System.setOut(System.out);
	}

	@Test
	void printInitMessageTest() {
		String initMessage = "숫자 야구 게임을 시작합니다.\n";
		io.printInitMessage();
		assertThat(outputStream.toString()).isEqualTo(initMessage);
	}

}
