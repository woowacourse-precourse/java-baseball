package baseball.domain;

import baseball.util.number.NumberGenerator;

public class Computer{

  private final NumberGenerator numberGenerator;

  public Computer(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  public Balls generateBalls(){
    return new Balls(numberGenerator.generate());
  }
}
