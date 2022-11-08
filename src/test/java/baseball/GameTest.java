package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
	// 데이터를 바이트 배열에 저장하기 위한 빈 바이트 배열을 생성 : ""
	final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	final PrintStream standardOut = System.out;


	@BeforeEach
	void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	void tearDown() {
		System.setOut(standardOut);
	}


	@Test
	void 시작문구() {
		Game game = new Game(3, 1, 2);
		String output = "숫자 야구 게임을 시작합니다.";
		game.printMessage(7);  // "숫자 야구 게임을 시작합니다." 문자열을 출력하는 메소드
		assertEquals(output, outputStreamCaptor.toString().trim());
	}

	@Test
	void 낫싱문구() {
		Game game = new Game(3, 1, 2);
		String output = "낫싱";
		game.printMessage(7);  // "숫자 야구 게임을 시작합니다." 문자열을 출력하는 메소드
		assertEquals(output, outputStreamCaptor.toString().trim());
	}

	@Test
	void 종료문구() {
		Game game = new Game(3, 1, 2);

		String output = "숫자 야구 게임을 시작합니다.";
		game.printMessage(7);  // "숫자 야구 게임을 시작합니다." 문자열을 출력하는 메소드
		assertEquals(output, outputStreamCaptor.toString().trim());
	}


}