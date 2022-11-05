package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class ComputerBallsGeneratorTest {
  ComputerBallsGenerator generator;
//  @BeforeEach
  @BeforeEach
  void setUp() {
    generator = new ComputerBallsGenerator(3);
  }

  @Test
  @Order(1)
  @DisplayName("")
  void isGenerateThreeBalls() {
    String str = generator.ballGenerator();
    assertEquals(3, str.length());
  }
}