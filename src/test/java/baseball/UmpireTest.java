package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UmpireTest {
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
    void gameStart() {
        String output = "숫자 야구 게임을 시작합니다.";
        Umpire.gameStart(); // outputStreamCaptor 에 출력하고자 한 문장이 저장됨
        assertEquals(output, outputStreamCaptor.toString().trim());
    }

}