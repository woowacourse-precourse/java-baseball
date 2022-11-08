package domain;

import domain.RandomBallsGenerator;
import org.junit.jupiter.api.BeforeEach;

class RandomBallsGeneratorTest {
  RandomBallsGenerator generator;
//  @BeforeEach
  @BeforeEach
  void setUp() {
    generator = new RandomBallsGenerator(3);
  }


}