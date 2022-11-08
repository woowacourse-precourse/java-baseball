package baseball;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class ComputerTest {

  @Test
  @RepeatedTest(100)
  void 컴퓨터가_생성하는_값이_유효한값인가() {
    Computer computer = new Computer();
    computer.setAnswerNumber();
  }
}
