package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

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

	@Test
		// 게임 시작 문구를 출력하는 기능
	void gameStart() {
		String output = "숫자 야구 게임을 시작합니다.";
		 // outputStreamCaptor 에 출력하고자 한 문장이 저장됨
		assertEquals(output, outputStreamCaptor.toString().trim());
	}

	@Test		// 중복되지 않는 랜덤 수 3개를 뽑는 기능
	void getRandomNumber() {

	}

	// 정답이 들어오기 전까지 반복해서 숫자를 입력받는 기능



	//사용자가 잘못된 값을 넣었을 때의 종료 기능
	@Test
	void wrongInput(){
		Player.numberString = String.valueOf(123);
		
	}

	//숫자 위치를 확인하는 기능
	//결과를 출력하는 기능
	//정답을 맞춘 후
}