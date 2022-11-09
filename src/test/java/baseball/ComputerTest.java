package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ComputerTest {

  @DisplayName("컴퓨터가 생성하는 값이 유효한 값인가")
  @RepeatedTest(100)
  void computerCanCreateValidAnswer() {
    Computer computer = new Computer();
    assertDoesNotThrow(() -> computer.setAnswerNumber());
  }
}
