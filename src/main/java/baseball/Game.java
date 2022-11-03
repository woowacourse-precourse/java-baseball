package baseball;

public class Game {
  public static int toBeContinued = 1;
  public Game() {
    this(toBeContinued);
  }
  public Game(int toBeContinued) {
    this.toBeContinued = toBeContinued;
  }
}
