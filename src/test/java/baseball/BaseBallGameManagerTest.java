package baseball;

import baseball.generator.MockRandomGenerator;
import baseball.input.MockInputReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class BaseBallGameManagerTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }

  @Test
  void 게임_시작메시지_출력() {
    Computer computer = new Computer(new MockRandomGenerator(1, 2, 3));
    Player player = new Player(new MockInputReader("123"));
    BaseBallGameManager gameManager = new BaseBallGameManager(computer, player);
    gameManager.runGame();

    String[] outputLines = outputStreamCaptor.toString().split("\\R");
    assertThat(outputLines[0]).isEqualTo("숫자 야구 게임을 시작합니다.");
  }
}
