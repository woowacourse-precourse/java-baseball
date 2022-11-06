package baseball;

public class Game {
  private int strike;
  private int ball;
  private int success = 0;

  public Computer computer;

  public Game(Computer computer) {
    this.computer = computer;
    this.strike = 0;
    this.ball = 0;
  }

  public void init() {
    computer.init();
    strike = 0;
    ball = 0;
  }

}
