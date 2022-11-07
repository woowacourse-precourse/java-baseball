package baseball.domain;

import baseball.util.number.NumberGenerator;

public class User implements Player{
  private final NumberGenerator numberGenerator;

  public User(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  @Override
  public Balls generateBalls(){
    return new Balls(numberGenerator.generate());
  }
}
