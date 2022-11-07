package baseball.domain;

import baseball.util.number.NumberGenerator;

public class User{
  private final NumberGenerator numberGenerator;

  public User(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  public Balls generateBalls(){
    return new Balls(numberGenerator.generate());
  }
}
