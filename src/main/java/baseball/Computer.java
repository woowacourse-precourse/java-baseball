package baseball;

import baseball.generator.RandomNumberGenerator;

import java.util.List;

public class Computer {

  private static final int ANSWER_LENGTH = 3;

  private List<Integer> answer;

  public Computer(RandomNumberGenerator generator) {
    generateAnswer(generator);
  }

  private void generateAnswer(RandomNumberGenerator generator) {
    this.answer = generator.generate(ANSWER_LENGTH);
  }
}

