package baseball.domain;

import baseball.util.number.NumberGenerator;

public class Computer implements Player{

  private final NumberGenerator numberGenerator;

  public Computer(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  @Override
  public Balls generateBalls(){
    return new Balls(numberGenerator.generate());
  }
}
