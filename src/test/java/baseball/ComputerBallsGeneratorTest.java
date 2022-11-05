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
  @DisplayName("생성된 balls 개수 확인")
  void isGenerateThreeBalls() {
    generator.ballsGenerator();
    assertEquals(3, generator.getBallsLength());
  }
}