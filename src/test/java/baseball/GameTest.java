package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class GameTest {
	// 데이터를 바이트 배열에 저장하기 위한 빈 바이트 배열을 생성 : ""
	final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	final PrintStream standardOut = System.out;


	@BeforeEach
	void setUp() {// setOut : 표준 출력 스트림을 재지정하는 데 사용 /사용자 정의 값으로 표준 출력 스트림을 설정
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	void tearDown() {
		System.setOut(standardOut);
	}



}