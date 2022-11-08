package baseball;

public class Game {

  private Player player;
  private Computer computer;

  public void setAnswer() {
    this.computer = new Computer();
    computer.setAnswer();
  }

  public void setGuess(String input) {
    this.player = new Player();
    player.setNumbers(input);
  }

}
